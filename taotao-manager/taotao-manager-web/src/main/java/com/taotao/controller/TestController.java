package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by feng on 2017/10/16.
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    void getTest(){
        System.out.println("this is a test");
    }

}
