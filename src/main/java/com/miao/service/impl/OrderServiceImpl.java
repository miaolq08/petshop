package com.miao.service.impl;

import com.miao.dao.OrderDao;
import com.miao.pojo.Order;
import com.miao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-19 19:05
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Order> findByUserId(Integer id) {
        return orderDao.findByUserId(id);
    }

    @Override
    public void addOrder(Integer total, Integer amount, Integer status, Integer paytype, String name, Integer uid, String phone, String address, Date date) {
        orderDao.addOrder(total,amount,status,paytype,name,uid,phone,address,date);
    }


}