package com.miao.dao;

import com.miao.pojo.Order;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-19 19:06
 **/
@Repository
public interface OrderDao {
    List<Order> findByUserId(Integer id);

    void addOrder(@RequestParam(name ="total" ) Integer total, @RequestParam(name ="amount" )Integer amount, @RequestParam(name ="status" ) Integer status,@RequestParam(name ="paytype" ) Integer paytype,@RequestParam(name ="name" ) String name,@RequestParam(name ="uid" ) Integer uid,@RequestParam(name ="phone" ) String phone,@RequestParam(name ="address" ) String address,@RequestParam(name ="date") Date date);

}
