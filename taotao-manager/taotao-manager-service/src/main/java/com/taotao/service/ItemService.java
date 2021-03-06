package com.taotao.service;


import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * Created by feng on 2017/10/15.
 */
public interface ItemService {
    TbItem getItemById(long itemId);
    EUDataGridResult getItemList(int page,int rows);
    TaotaoResult ctreateItem(TbItem item,String desc,String itemParam) throws Exception;
}
