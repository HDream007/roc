package com.rimi.roc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 惜-梦  接口
 * @description swagger ui
 * @date 2019-02-21 14:56
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket restApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //在这个包下的才类产生接口
                .apis(RequestHandlerSelectors.basePackage("com.rimi.roc.api"))
                .paths(PathSelectors.any())
                .build();
    }
}
