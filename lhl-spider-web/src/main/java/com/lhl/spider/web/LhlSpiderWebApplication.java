package com.lhl.spider.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.lhl"})
public class LhlSpiderWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LhlSpiderWebApplication.class, args);
    }

}
