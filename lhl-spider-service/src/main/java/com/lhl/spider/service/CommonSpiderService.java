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

    void sleep(long times);
}
