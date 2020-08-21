package com.miao.service.impl;

import com.miao.pojo.Items;
import com.miao.dao.ItemsDao;
import com.miao.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-19 19:52
 **/
@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsDao itemsDao;
    @Override
    public void addItems(Items items) {
        itemsDao.addItems(items);
    }
}
