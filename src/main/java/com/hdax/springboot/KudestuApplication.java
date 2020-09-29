package com.hdax.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.hdax.springboot.dao")
public class KudestuApplication {
    public static void main(String[] args) {
        SpringApplication.run(KudestuApplication.class, args);
    }
}
