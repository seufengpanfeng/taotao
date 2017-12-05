package com.taotao.search.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by feng on 2017/12/1.
 */
@Controller
@RequestMapping("/manager")
public class ItemController {
    @Autowired
    private ItemService itemService;
    /*
    导入商品库到索引库
     */
    @RequestMapping("/importall")
    @ResponseBody
    public TaotaoResult importAllItems(){
        System.out.println("haha");
        TaotaoResult result = itemService.importAllItems();
        System.out.println("haha2");
        return  result;
    }
}
