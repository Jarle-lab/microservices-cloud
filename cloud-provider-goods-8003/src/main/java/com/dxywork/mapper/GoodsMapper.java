package com.dxywork.mapper;

import com.dxywork.pojo.Goods;

import java.util.List;

public interface GoodsMapper {
    //查询所有商品的集合
    public Goods list(String id);

    //修改指定商品
    public int update(Goods g);

    //删除指定商品
    public int del(String id);

    //增加指定商品
    public int add(Goods goods);
}
