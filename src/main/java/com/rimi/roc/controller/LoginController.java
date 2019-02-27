package com.rimi.roc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 惜-梦
 * @description 登录
 * @date 2019-02-27 14:51
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String login(){
        return "/login";
    }
}
