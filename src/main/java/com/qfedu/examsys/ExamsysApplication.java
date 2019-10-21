package com.qfedu.examsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching //启用缓存
@SpringBootApplication
@MapperScan("com.qfedu.examsys.dao")
public class ExamsysApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(ExamsysApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ExamsysApplication.class, args);
    }

}
