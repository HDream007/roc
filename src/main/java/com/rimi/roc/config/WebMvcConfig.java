package com.rimi.roc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 惜-梦
 * @description
 * @date 2019-02-19 17:55
 */
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //swaggerUI  映射
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INFO/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INFO/resources/webjars/");
    }

    /**
     * 解决跨域问题
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET","POST","DELETE","PUT","PATCH")
                .maxAge(3600);
    }
}
