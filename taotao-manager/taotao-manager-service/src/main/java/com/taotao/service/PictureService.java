package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * Created by feng on 2017/10/30.
 */
public interface PictureService {
    Map uploadPicture(MultipartFile uploadFile);
}
