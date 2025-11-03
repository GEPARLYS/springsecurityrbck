package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author j
 * @Date 2019/9/10 15:25
 * @Version 1.0
 */
@Controller
public class HomeController {
    @RequestMapping("/index")
    public String index(){
        return "main";
    }
}
