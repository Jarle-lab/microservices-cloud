package com.dxywork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //开启注册中心发现，让注册中心扫描并发现该服务
@MapperScan("com.dxywork.mapper")
public class GoodsApp8003 {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApp8003.class, args);
    }
}
