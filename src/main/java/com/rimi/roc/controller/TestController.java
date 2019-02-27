package com.rimi.roc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 惜-梦
 * @description 测试
 * @date 2019-02-27 14:55
 */
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping(value = "/test")
    public String test(){
        return "test";
    }

}
