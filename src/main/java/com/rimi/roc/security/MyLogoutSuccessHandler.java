package com.rimi.roc.security;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 惜-梦
 * @description 退出登录成功的处理器操作
 * @date 2019-02-27 14:43
 */
@Slf4j
@Component
public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("退出成功");

        JSONObject object = new JSONObject();
        object.put("code",0);
        object.put("msg","退出登录成功");
        response.getWriter().print(object);
        super.onLogoutSuccess(request, response, authentication);


    }
}
