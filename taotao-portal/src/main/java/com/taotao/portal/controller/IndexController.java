package com.taotao.portal.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by feng on 2017/11/13.
 */
@Controller
public class IndexController {
    @Autowired
    private ContentService contentService;
    @RequestMapping("index")
    public String showIndex(Model model){
        String adJson = contentService.getContentList();
        model.addAttribute("ad1",adJson);
        System.out.println("这里执行了");
        return "index";
    }
    @RequestMapping(value ="/httpclient/post",method = RequestMethod.POST)
    @ResponseBody
    public  String testPost(String username, String password){
        return "uesrname"+username+"\tpassword:"+password;
    }
//    @RequestMapping("login")
//    public String show1Index(){
//        System.out.println("哪里执行了");
//        return "login";
//    }
}
