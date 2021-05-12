package com.dxywork.service.impl;

import com.dxywork.mapper.GoodsMapper;
import com.dxywork.pojo.Goods;
import com.dxywork.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceimpl implements GoodsService {
    @Resource
    GoodsMapper goods;

    @Override
    public Goods list(String id) {
        return goods.list(id);
    }

    @Override
    public int update(Goods g) {
        return goods.update(g);
    }

    @Override
    public int del(String id) {
        return goods.del(id);
    }

    @Override
    public int add(Goods goodss) {
        return goods.add(goodss);
    }
}
