package com.taotao.rest.service;

import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * Created by feng on 2017/11/20.
 */
public interface ContentService {
    List<TbContent> getContentList(long contentCid);
}
