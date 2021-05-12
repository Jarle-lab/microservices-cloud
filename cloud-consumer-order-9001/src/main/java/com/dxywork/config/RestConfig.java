package com.dxywork.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
    /*在接触springCloud的组件负载均衡Ribbon的时候，一个注解大家一定不会陌生，该注解就是@LoadBalanced注解，
   我们在使用这个注解后，就能在调用其他微服务的时候，通过服务实例名称就能进行调用其他的微服务，而不是直接把要调用的微服务的ip和端口号写死在代码当中。*/
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
