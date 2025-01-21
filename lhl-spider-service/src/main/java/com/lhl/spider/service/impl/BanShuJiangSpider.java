package com.lhl.spider.service.impl;

import com.lhl.spider.service.CommonSpiderService;
import com.lhl.spider.service.SeleniumService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class BanShuJiangSpider  extends CommonSpiderServiceImpl implements CommonSpiderService {

    private final String BASIC_FILE_PATH = "/images/banshujiang/";

    @Resource
    private SeleniumService seleniumService;

    @Override
    public String getPageSource(String url) {
        return super.getPageSource(url);
    }

    @Override
    public Document parse(String htmlBody) {
        return super.parse(htmlBody);
    }

    @Override
    List<String> getUrls(Document document) {
        Elements links = document.select("a");
        int size = links.size();
        List<String> urls = new ArrayList<>(size);
        for (Element link : links) {
            String href = link.attr("href");
            if (href.indexOf("www")==1){
                href = link.absUrl("href");
            }
            urls.add(href);
        }
        return urls;
    }

    @Override
    void createFilePath(String filePath) {
        try {
            Path path = Paths.get(filePath);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    void downloadImage(String url, String filePah) {
        URL downloadUrl = null;
        try {
            downloadUrl = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try(InputStream inputStream = downloadUrl.openStream();
            FileOutputStream outputStream = new FileOutputStream(filePah)){
           byte[] buffer = new byte[1024];
           int bytesRead;
           while ((bytesRead = inputStream.read(buffer)) != -1){
               outputStream.write(buffer,0,bytesRead);
           }
        }catch (Exception e){
            log.error("downloadImage.error",e.getCause());
        }
    }

    @Override
    void pageDetail(String url) {
        WebDriver driver = seleniumService.openWebPage(url);
//        String baseUrl = url.substring(0,url.indexOf(".cn")+3);
        downloadDetailPageImage(url);

        // click pdf links
        List<WebElement> elements = driver.findElements(By.cssSelector("div.span6 li"));
        for (WebElement element : elements) {
            String span = element.findElement(By.cssSelector("span")).getText();
            if ("PDF".equals(span)) {
                // click pdf
                WebElement spanElement = element.findElement(By.cssSelector("a"));
                spanElement.click();
            }
        }

        sleep(1000);
        seleniumService.switchToWindow(driver);

        // get code
        List<WebElement> divs = driver.findElements(By.cssSelector("div"));
        String code = "";
        for (WebElement div : divs) {
            String text = div.getText();
            if (text.startsWith("请先复制提取码")){
                WebElement spanElement = div.findElement(By.cssSelector("span"));
                code = spanElement.getText();
            }
        }
        log.info("code:{}",code);
        sleep(7000);

        // send key and click button
        WebElement input = driver.findElement(By.cssSelector("input"));
        input.sendKeys(code);
        driver.findElement(By.cssSelector("button")).click();

        sleep(3000);
        seleniumService.switchToWindow(driver);

        // click low speed download button
        List<WebElement> downloadUrl = driver.findElements(By.cssSelector("div.position-relative"));
        for (WebElement element : downloadUrl) {
            String span = element.findElement(By.cssSelector("span")).getText();
            if (span.indexOf("低速") != -1){
                element.findElement(By.cssSelector("button")).click();
            }
        }

        sleep(3000);
        seleniumService.switchToWindow(driver);

        // get progress bar,
        while (true) {
            sleep(1000);
            WebElement element = driver.findElement(By.id("transferProgress"));
            String ariaValuenow = element.getAttribute("aria-valuenow");
            if (null != ariaValuenow){
                System.out.println("当前进度："+ariaValuenow);
                if (ariaValuenow.equals("100")){
                    break;
                }
            }
        }

        sleep(3000);
        seleniumService.closeWebPage(driver);
    }

    private void downloadDetailPageImage(String url) {
        String pageSource = getPageSource(url);
        Document document = parse(pageSource);
        String imageUrl = document.select("div.span6 img").attr("src");
        String bookTitle = document.select("div.span6 div.ebook-title a").text();
        String filePath =  BASIC_FILE_PATH+bookTitle.replace(" ","");
        createFilePath(filePath);
        downloadImage(imageUrl,filePath);
    }
}
