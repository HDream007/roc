package com.rimi.roc.controller;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 惜-梦
 * @description 测试
 * @date 2019-02-27 14:55
 */
@Controller
public class TestController {

    @Autowired
    private FastFileStorageClient client;


    @ResponseBody
    @RequestMapping(value = "/test")
    public String test(){
        return "test";
    }

    public StorePath upload(MultipartFile file) throws IOException {

        StorePath url = client.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);

        return url;
    }

}
