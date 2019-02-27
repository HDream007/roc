package com.rimi.roc.security;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 惜-梦
 * @description 登陆成功的处理器
 * @date 2019-02-27 14:40
 */

@Slf4j
@Component
public class MySuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        logger.info("登录成功");
        JSONObject object = new JSONObject();
        object.put("code",0);
        object.put("data",object);
        response.getWriter().print(object);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
