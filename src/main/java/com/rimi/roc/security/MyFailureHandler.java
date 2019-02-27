package com.rimi.roc.security;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 惜-梦
 * @description 登录失败的处理器操作
 * @date 2019-02-27 14:24
 */
@Slf4j
@Component
public class MyFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登录失败");
        JSONObject object = new JSONObject();
        object.put("code",1);
        object.put("msg","登录失败,请检查用户名或密码是否正确！");
        response.getWriter().print(object.toString());
        super.onAuthenticationFailure(request, response, exception);
    }
}
