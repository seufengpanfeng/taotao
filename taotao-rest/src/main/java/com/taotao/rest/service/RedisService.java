package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * Created by feng on 2017/11/25.
 */
public interface RedisService {
    TaotaoResult syncContent(long contentCid);
}
