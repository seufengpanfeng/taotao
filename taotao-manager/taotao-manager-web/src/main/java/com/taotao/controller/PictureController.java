package com.taotao.controller;

import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by feng on 2017/11/4.
 * 上传图片处理
 */
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String pictureUpLoad(MultipartFile uploadFile){
        Map result = pictureService.uploadPicture(uploadFile);
       // System.out.println("result is:"+result);
        //为了保证功能的兼容性，要把result转换成json格式的字符串
        String json = JsonUtils.objectToJson(result);
      //  System.out.println("map is:"+json);
        return json;
    }
}
