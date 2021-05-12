package com.dxywork.controller;

import com.dxywork.pojo.Goods;
import com.dxywork.service.GoodsClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    public static final String INVOKE_URL = "http://cloud-provider-goods";
    @Resource
    private RestTemplate restTemplate;


    @RequestMapping("/downOrder/{id}")
    public String downOrder(@PathVariable String id) {
        //向商品的服务发送请求，获取指定的商品信息
        /*
          RestTemplate是spring提供的可以提供访问rest服务的客户端工具类，
          提供多种快捷的访问远程的方法，大大提高了客户端的编程效率。
         */
        String result = restTemplate.getForObject(INVOKE_URL + "/goods/glist?id=" + id, String.class);
        return "下订单成功，购买的书籍信息为：" + result;
    }

}
