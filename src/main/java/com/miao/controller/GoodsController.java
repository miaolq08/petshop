package com.miao.controller;

import com.miao.pojo.Goods;
import com.miao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-15 17:59
 **/
@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("findAll")
    public void findAll(){
        List<Goods> list=goodsService.findAll();
    }
}
