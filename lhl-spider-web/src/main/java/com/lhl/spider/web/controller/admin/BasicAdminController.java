package com.lhl.spider.web.controller.admin;

import com.lhl.spider.web.controller.BasicController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BasicAdminController extends BasicController {

    @RequestMapping(value = "/index")
    public String index() {
        return "admin/index";
    }
}
