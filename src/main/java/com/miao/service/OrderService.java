package com.miao.service;

import com.miao.pojo.Order;

import java.util.Date;
import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-19 19:05
 **/
public interface OrderService {
    List<Order> findByUserId(Integer id);


    void addOrder(Integer total, Integer amount, Integer status, Integer paytype, String name, Integer uid, String phone, String address);

    List<Order> findAll();

    void deleteById(Integer id);

    void updateOrder(Order order);

    Order findByid(Integer orderid);

}
