package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页跳转
 * Created by feng on 2017/10/16.
 */
@Controller
public class PageController {
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }
/*
展示其他页面
 */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
