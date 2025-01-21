package com.lhl.spider.service.impl;

import com.lhl.spider.service.SeleniumService;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class SeleniumServiceImpl implements SeleniumService {

    private final String DRIVER_PATH = "lhl-spider-service/src/main/resources/driver/chromedriver";

    @Override
    public WebDriver openWebPage(String url){
        File driverPath = new File(DRIVER_PATH);
        ChromeDriverService service =
                new ChromeDriverService.Builder().usingDriverExecutable(driverPath).build();
        /**
         * headLess mode
         */
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");

        WebDriver driver = new ChromeDriver(service,options);
        driver.manage().window().maximize();
        driver.get(url);
        log.info("page.title:{}",driver.getTitle());
        return driver;
    }

    @Override
    public void closeWebPage(WebDriver webDriver){
        webDriver.quit();
    }

    @Override
    public void switchToWindow(WebDriver driver){
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> windows = new ArrayList<>(windowHandles);
        driver.switchTo().window(windows.get(windows.size() - 1));
    }



    public static void main(String[] args){
//        String url = "http://www.banshujiang.cn/e_books/2956";
//        File driverPath = new File("lhl-spider-service/src/main/resources/driver/chromedriver");
//        ChromeDriverService service =
//                new ChromeDriverService.Builder().usingDriverExecutable(driverPath).build();
//
//        WebDriver driver = new ChromeDriver(service);
//        try {
//            driver.manage().window().maximize();
//            driver.get(url);
//
//            List<WebElement> elements = driver.findElements(By.cssSelector("div.span6 li"));
//            for (WebElement element : elements) {
//                String span = element.findElement(By.cssSelector("span")).getText();
//                if ("PDF".equals(span)) {
//                    // click pdf
//                    WebElement spanElement = element.findElement(By.cssSelector("a"));
//                    spanElement.click();
//                }
//            }
//            Thread.sleep(1000);
//            // change to the last window
//            Set<String> windowHandles = driver.getWindowHandles();
//            ArrayList<String> windows = new ArrayList<>(windowHandles);
//            driver.switchTo().window(windows.get(windows.size() - 1));

//            String windowHandle = driver.getWindowHandle();
//            System.out.println(windowHandle);
//            String pageSource = driver.getPageSource();
//            System.out.println(pageSource);
////            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
//            String title = driver.getTitle();
//            System.out.println(title);

//            List<WebElement> divs = driver.findElements(By.cssSelector("div"));
//            String code = "";
//            for (WebElement div : divs) {
//                String text = div.getText();
//                if (text.startsWith("请先复制提取码")){
//                    WebElement spanElement = div.findElement(By.cssSelector("span"));
//                    code = spanElement.getText();
//                }
//            }
//            System.out.println("提取码:"+code);
//            /**
//             * sleep 5000 wait auto
//             */
//            Thread.sleep(7000);

//            Set<String> windowHandles1 = driver.getWindowHandles();
//            ArrayList<String> windows1 = new ArrayList<>(windowHandles1);
//            driver.switchTo().window(windows1.get(windows1.size() - 1));

//            WebElement input = driver.findElement(By.cssSelector("input"));
//            input.sendKeys(code);
//            driver.findElement(By.cssSelector("button")).click();
//
//            Thread.sleep(3000);
//
//            Set<String> windowHandles2 = driver.getWindowHandles();
//            ArrayList<String> windows2 = new ArrayList<>(windowHandles2);
//            driver.switchTo().window(windows2.get(windows2.size() - 1));
//            System.out.println(driver.getPageSource());



//            List<WebElement> downloadUrl = driver.findElements(By.cssSelector("div.position-relative"));
//            for (WebElement element : downloadUrl) {
//                String span = element.findElement(By.cssSelector("span")).getText();
//                if (span.indexOf("低速") != -1){
//                    element.findElement(By.cssSelector("button")).click();
//                }
//            }
//
//            Thread.sleep(3000);
//            Set<String> windowHandles3 = driver.getWindowHandles();
//            ArrayList<String> windows3 = new ArrayList<>(windowHandles3);
//            driver.switchTo().window(windows3.get(windows3.size() - 1));
//            System.out.println(driver.getPageSource());
//
//            while (true) {
//                Thread.sleep(1000);
//                WebElement element = driver.findElement(By.id("transferProgress"));
//                String ariaValuenow = element.getAttribute("aria-valuenow");
//                if (null != ariaValuenow){
//                    System.out.println("当前进度："+ariaValuenow);
//                    if (ariaValuenow.equals("100")){
//                        break;
//                    }
//                }
//            }

//            driver.findElement(By.cssSelector("a.transferItemBtn")).click();

//            Thread.sleep(3000);
//            driver.quit();

//            System.out.println(driver.getPageSource());
//            driver.quit();
//            System.out.println(driver.getTitle());
//            String pageSource = driver.getPageSource();
//            System.out.println(pageSource);
//            driver.findElement(By.name(""));
//            driver.findElements(By.cssSelector(""));
//            driver.quit();
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
    }
}
