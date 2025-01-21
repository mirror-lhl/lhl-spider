package com.lhl.spider.service.impl;

import com.lhl.spider.service.CommonSpiderService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Component
@Slf4j
public abstract class CommonSpiderServiceImpl implements CommonSpiderService {

    @Override
    public String getBasicUrl(String url) {
        return url;
    }

    @Override
    public String getPageSource(String url) {
        try {
            String body = Jsoup.connect(url).execute().body();
            log.info("page_resource url:{},body:{}", url,body);
            return body;
        } catch (IOException e) {
            log.error("get_page_resource.error",e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Document parse(String htmlBody){
        Document parse = Jsoup.parse(htmlBody, "utf-8");
        return parse;
    }

    @Override
    public void sleep(long times){
        try {
            Thread.sleep(times);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void downloadImage(String url, String filePah) {
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

    /**
     * get urls
     * @param document
     * @return
     */
    abstract List<String> getUrls(Document document);

    /**
     * create file path
     * @param filePath
     */
    abstract void createFilePath(String filePath);

    /**
     * page detail
     * @param url
     */
    abstract void pageDetail(String url);

    abstract void spider(String url);

    public static void main(String[] args) throws IOException {
//        String detailUrl = "http://www.banshujiang.cn/e_books/4791";
//        Document document = Jsoup.connect(detailUrl).execute().parse();
//
//        String attr = document.select("div.span6 img").attr("src");
//        System.out.println(attr);
//        String bookeTitle = document.select("div.span6 div.ebook-title a").text();
//        System.out.println(bookeTitle);
//        String baseUrl = detailUrl.substring(0,detailUrl.indexOf(".cn")+3);
//        System.out.println(baseUrl);
//        Elements select = document.select("div.span6 li");
//
//        Map<String,String> headers = new HashMap<>();
//        headers.put("Referer",detailUrl);
//        headers.put("cookie","Hm_lvt_38a41a4c5062c2a88d0e6083f47105ab=1737279427; HMACCOUNT=0844FF438F5029A0; Hm_lpvt_38a41a4c5062c2a88d0e6083f47105ab=1737294370");
//
//        for (Element element : select) {
//            String liSpan = element.select("span").text();
//            String fileUrl  = element.select("a").attr("href");
//            if (!fileUrl.startsWith("http")){
//                fileUrl = baseUrl + fileUrl;
//            }
//            System.out.println(String.format("fielname:%s,url:%s",liSpan,fileUrl));
//            String body = Jsoup.connect(fileUrl).header("Referer", detailUrl).execute().body();
//            System.out.println(String.format("body:%s",body));
//        }



//        String url = "http://www.banshujiang.cn/";
//        Document document = Jsoup.connect(url).execute().parse();
//        System.out.println(document.body());
//
//        Elements links = document.select("a");
//        for (Element link : links) {
//            String href = link.attr("href");
//            System.out.println(href);
//            String realHref = link.absUrl("href");
//            System.out.println(realHref);
//        }

//        Elements select = document.select("img[src]");
//        for (Element element : select) {
//            String src = element.attr("src");
//            System.out.println(src);
//        }
//        Elements hrefs = document.select("a[href]");
//        for (Element element : hrefs) {
//            String href = element.attr("href");
//            System.out.println(href);
//        }
//        Elements select = document.select("li");
//        for (Element element : select) {
//            String href = element.select("a").attr("href");
//            String src = element.select("img").attr("src");
//        }
//        String attr = document.getElementsByTag("img").attr("src");
//        System.out.println(attr);
    }
}
