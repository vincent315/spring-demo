package com.xzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sysuser")
public class SysuserController {
    @RequestMapping("/login")
    public String login(){
        //处理登陆操作


        return "main";
    }

}
