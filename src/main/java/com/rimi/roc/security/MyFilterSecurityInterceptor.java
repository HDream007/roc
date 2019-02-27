package com.rimi.roc.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
/**
 * @author 惜-梦
 * @description admin 过滤器 拦截器
 * @date 2019-02-27 18:18
 */
@Slf4j
@Component
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private FilterInvocationSecurityMetadataSource securityMetadataSource;

    @Autowired
    public void setMyAccessDecisionManager(MyAccessDecisionManager myAccessDecisionManager){
        super.setAccessDecisionManager(myAccessDecisionManager);
    }


    @Override
    public Class<?> getSecureObjectClass() {
        return null;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain Chain) throws IOException, ServletException {
        FilterInvocation invocation = new FilterInvocation(request,response,Chain);
        invoke(invocation);
    }

    public void invoke(FilterInvocation invocation){
        logger.info("调用拦截器");
        //先调用自己定义的filter
        InterceptorStatusToken beforeInvocation = super.beforeInvocation(invocation);
        try {
            invocation.getChain().doFilter(invocation.getRequest(),invocation.getResponse());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }finally {
            super.afterInvocation(beforeInvocation,null);
        }
    }

}
