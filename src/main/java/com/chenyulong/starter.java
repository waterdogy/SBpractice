package com.chenyulong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chenyulong.mapper")
public class starter {

    public static void main(String[] args){
        SpringApplication.run(starter.class, args);
    }
}
