package com.rimi.roc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 惜-梦
 */
@SpringBootApplication
@MapperScan(basePackages = "com.rimi.roc.mapper")
public class RocApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocApplication.class, args);
    }

}
