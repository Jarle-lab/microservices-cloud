package com.dxywork.controller;

import com.dxywork.pojo.Goods;
import com.dxywork.service.GoodsClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    GoodsClientService goodsClientService;

    @RequestMapping(value = "/downOrder/{id}")
    public String downOrder(@PathVariable String id) {
        Goods result = goodsClientService.getGoods(id);
        return "下订单成功，购买的书籍信息为：" + result;
    }
}
