package com.miao.dao;

import com.miao.pojo.Order;
import org.apache.ibatis.annotations.Param;
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
    void addOrder(@Param("total" ) Integer total, @Param("amount" )Integer amount, @Param("status" ) Integer status, @Param("paytype" ) Integer paytype, @Param("name") String name, @Param("user_id" ) Integer user_id, @Param("phone" ) String phone, @Param("address" ) String address);

    List<Order> findAll();

    void deleteById(Integer id);

    void updateOrder(Order order);

    Order findByid(Integer id);

}
