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
}
