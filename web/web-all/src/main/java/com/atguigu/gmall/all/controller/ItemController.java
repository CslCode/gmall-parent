package com.atguigu.gmall.all.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chen
 * @creat 2020-12-02-8:48
 */
@Controller
public class ItemController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
