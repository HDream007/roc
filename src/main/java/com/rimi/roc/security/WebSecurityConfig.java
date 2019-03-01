package com.rimi.roc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * 安全配置
 * @author admin
 * @date 2019-02-19
 */
@Configuration
@EnableWebSecurity                     //安全配置适配器
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyFailureHandler myFailureHandler;
    @Autowired
    private MySuccessHandler mySuccessHandler;
    @Autowired
    private MyLogoutSuccessHandler myLogoutSuccessHandler;
    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getUserDetailsService());
    }

    @Bean
    UserDetailsService getUserDetailsService(){
        return new MyuserDetailsServiceImpl();
    }

    //密码加密操作
    @Bean
    public PasswordEncoder passwordEncoder(){
        //加密方式
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

                http
                 //防止跨域请求 防止恶意攻击
                .csrf()
                 //禁用csrf
                 .disable()
                 .formLogin()
                //登录失败跳转的的地址
                .failureForwardUrl("/login")
                //登录失败的处理器
                .failureHandler(myFailureHandler)
                .successHandler(mySuccessHandler)
                //登陆的请求页面
                .loginPage("/")
                //登录操作的请求
                .loginProcessingUrl("/login")
                //登录不需要权限
                .permitAll()
                .and()
                //退出登录
                .logout()
                //退出登录的地址
                .logoutUrl("/logout")
                //退出成功的处理器
                .logoutSuccessHandler(myLogoutSuccessHandler)
                //使Httpsecurity 失效  清除session中的内容
                .invalidateHttpSession(true)
                //退出操作不需要权限
                .permitAll()
                .and()
                .authorizeRequests()
                // 所有的请求都需要登录
                .anyRequest().authenticated();

            //添加自定义拦截器
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);


    }
}
