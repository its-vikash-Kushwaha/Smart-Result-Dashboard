package com.smart.result.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

    @RequestMapping
    public String index(){
        System.out.println("Home page");
        return "index";
    }
}
