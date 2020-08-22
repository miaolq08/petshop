package com.miao.dao;

import com.miao.pojo.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {
    List<Goods> findAll();

    Goods findById(Integer id);

    List<Goods> findByTypeId(Integer typeid);

    void deleteById(Integer id);

    void updateGoods(Goods goods);

    void addGoods(Goods goods);

    List<Goods> findByName(String name);

}
