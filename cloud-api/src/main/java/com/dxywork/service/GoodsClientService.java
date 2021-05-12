package com.dxywork.service;

import com.dxywork.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cloud-provider-goods", path = "/goods")
public interface GoodsClientService {

    @RequestMapping("/glist")
    public Goods getGoods(@RequestParam(value = "id", required = false) String id);
}
