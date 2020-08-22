package com.miao.service;

import com.miao.pojo.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> findAll();

    Goods findById(Integer id);

    List<Goods> findByTypeId(Integer typeid);

    void deleteById(Integer id);

    void updateGoods(Goods goods);

    void addGoods(Goods goods);

    List<Goods> findByName(String name);
}
