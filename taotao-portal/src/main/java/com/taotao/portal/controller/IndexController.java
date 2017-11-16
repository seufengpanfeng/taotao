package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by feng on 2017/11/13.
 */
@Controller
public class IndexController {
    @RequestMapping("index")
    public String showIndex(){
        System.out.println("这里执行了");
        return "index";
    }

//    @RequestMapping("login")
//    public String show1Index(){
//        System.out.println("哪里执行了");
//        return "login";
//    }
}
