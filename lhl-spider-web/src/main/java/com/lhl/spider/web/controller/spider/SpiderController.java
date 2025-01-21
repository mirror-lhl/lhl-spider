package com.lhl.spider.web.controller.spider;

import com.lhl.spider.service.CommonSpiderService;
import com.lhl.spider.web.controller.BasicController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/spider")
public class SpiderController extends BasicController {

    @Resource
    private CommonSpiderService commonSpiderService;

    @GetMapping("/get_page_source")
    @ResponseBody
    public String getPageSource(String url) {
        return commonSpiderService.getPageSource(url);
    }

}
