package com.rimi.roc.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author 惜-梦
 * @description 判断是否拥有权限的决策方法
 * @date 2019-02-27 18:23
 */
@Slf4j
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    /**
     *
     * @param authentication  权限的集合
     * @param object 包含用户的请求信息
     * @param configAttributes 判断是否在权限表中
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (configAttributes == null || configAttributes.size() == 0 ){
            return;
        }
        //遍历需要验证的权限
        for (ConfigAttribute configAttribute : configAttributes) {
            //遍历用户的权限
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                if (configAttribute.getAttribute().equals(authority.getAuthority())){
                    return;
                }
            }
        }
        //log.error("没有权限");
        throw new AccessDeniedException("没有权限");

    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
