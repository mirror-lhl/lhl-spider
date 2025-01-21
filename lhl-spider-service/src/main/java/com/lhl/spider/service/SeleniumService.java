package com.lhl.spider.service;

import org.openqa.selenium.WebDriver;

public interface SeleniumService {

    WebDriver openWebPage(String url);

    void closeWebPage(WebDriver webDriver);

    void switchToWindow(WebDriver driver);
}
