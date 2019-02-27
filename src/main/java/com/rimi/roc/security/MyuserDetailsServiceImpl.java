package com.rimi.roc.security;

import com.rimi.roc.mapper.AdminMapper;
import com.rimi.roc.pojo.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.security.Permission;
import java.util.List;

/**
 * @author 惜-梦
 * @description 用户信息
 * @date 2019-02-27 16:15
 */
@Slf4j
@Component
public class MyuserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户
        Admin admin = adminMapper.selectByUsername(username);
        if (admin!=null){
            //获取权限信息
            List<Permission> permissionList;
            //判断用户是否是超级管理员

            return new User(username,admin.getPassword(),null);
        }else{

        }



        return null;
    }
}
