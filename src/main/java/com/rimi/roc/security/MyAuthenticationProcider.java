package com.rimi.roc.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author 惜-梦
 * @description 验证用户和密码的操作
 * @date 2019-02-27 16:58
 */
@Slf4j
@Component
public class MyAuthenticationProcider implements AuthenticationProvider {

    @Autowired
    private MyuserDetailsServiceImpl userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       //获取用户名
        String username = authentication.getName();
        String password = (String)authentication.getCredentials();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        //判断密码
        if (!passwordEncoder.matches(password,userDetails.getPassword())) {
            //log.error("密码错误");
            throw new BadCredentialsException("密码错误");
        }

        return new UsernamePasswordAuthenticationToken(userDetails,userDetails.getPassword(),userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
