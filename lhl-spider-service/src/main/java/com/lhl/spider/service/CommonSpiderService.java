package com.lhl.spider.service;

import org.jsoup.nodes.Document;

public interface CommonSpiderService {
    /**
     * get basic url
     * @param url
     * @return
     */
    String getBasicUrl(String url);

    /**
     * get page source
     * @param url
     * @return
     */
    String getPageSource(String url);

    /**
     * parse html to document
     * @param htmlBody
     * @return
     */
    Document parse(String htmlBody);

    /**
     * sleep times
     * @param times
     */
    void sleep(long times);

    /**
     * download images
     * @param url
     * @param filePah
     */
    void downloadImage(String url, String filePah);
}
