package com.miao.service.impl;

import com.miao.dao.GoodsDao;
import com.miao.pojo.Goods;
import com.miao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-15 18:05
 **/
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> findAll() {
        return goodsDao.findAll();
    }

    @Override
    public Goods findById(Integer id) {
        return goodsDao.findById(id);
    }

    @Override
    public List<Goods> findByTypeId(Integer typeid) {
        return goodsDao.findByTypeId(typeid);
    }

    @Override
    public void deleteById(Integer id) {
        goodsDao.deleteById(id);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }

    @Override
    public void addGoods(Goods goods) {
        goodsDao.addGoods(goods);
    }

    @Override
    public List<Goods> findByName(String name) {
        return goodsDao.findByName(name);
    }
}
