package com.dxywork.controller;

import com.dxywork.pojo.Goods;
import com.dxywork.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private GoodsService goods;

    @RequestMapping("/glist")
    public Goods getGoods(String id) {
        Goods g = goods.list(id);
        g.setServerPort(serverPort);
        return g;
    }
}
