package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;

import java.util.List;

/**
 * Created by feng on 2017/10/22.
 */
public interface ItemCatService {
    List<EUTreeNode> getCatList(long parentId);
}
