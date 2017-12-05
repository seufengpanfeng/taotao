package com.taotao.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by feng on 2017/11/20.
 */
@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    private TbContentMapper contentMapper;
    @Value("${REST_BASE_URL}")
    private  String REST_BASE_URL;
    @Value("${REST_CONTENT_SYNC_URL}")
    private  String REST_CONTENT_SYNC_URL;
    @Override
    public TaotaoResult insertContent(TbContent content) {
        //补全pojo内容
        content.setCreated(new Date());
        content.setUpdated(new Date());
        contentMapper.insert(content);

        //添加缓存同步逻辑,这里可以看成是rest服务的接口
        try{
            HttpClientUtil.doGet(REST_BASE_URL+REST_CONTENT_SYNC_URL+content.getCategoryId());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("出现异常");
        }
        return TaotaoResult.ok();
    }

}
