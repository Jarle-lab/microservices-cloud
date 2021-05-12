package com.dxywork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.dxywork.service")
public class OrderApp9002 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp9002.class, args);
    }
}
