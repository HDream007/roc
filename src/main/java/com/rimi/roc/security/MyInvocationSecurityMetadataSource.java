package com.rimi.roc.security;

import com.rimi.roc.mapper.PermissionMapper;
import com.rimi.roc.pojo.Permission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author 惜-梦
 * @description 启动时加载所有需要验证的权限
 * @date 2019-02-27 18:59
 */
@Slf4j
@Component
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private PermissionMapper permissionMapper;

    private HashMap<String,List<ConfigAttribute>> map = new HashMap<String, List<ConfigAttribute>>();

    private void loadResourceDefine(){
       // log.info("加载权限");
        List<Permission> permissionList = permissionMapper.selectAll();
        for (Permission permission : permissionList) {
            List<ConfigAttribute> attributes = new ArrayList<>();
            SecurityConfig config = new SecurityConfig(permission.getName());
            //此处添加的权限的名称 用于AccessDecisionManager 中的decide做验证
            attributes.add(config);
            map.put(permission.getExpression(),attributes);
        }
    }

    /**
     * 判断用的url是否在权限表中
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (map.size()==0){
            loadResourceDefine();
        }
        HttpServletRequest httpServletRequest = ((FilterInvocation) object).getHttpRequest();
        for (String url : map.keySet()) {
            AntPathRequestMatcher matcher = new AntPathRequestMatcher(url);

            //判断用户的请求是否包含需要验证的地址
            if (matcher.matches(httpServletRequest)){
                return map.get(url);
            }
        }

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
