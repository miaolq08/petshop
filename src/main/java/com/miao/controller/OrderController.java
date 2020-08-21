package com.miao.controller;

import com.miao.pojo.Order;
import com.miao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-19 19:00
 **/
@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("userOrder")
    public String order(Integer id, HttpSession session){
        List<Order> list =orderService.findByUserId(id);
        session.setAttribute("orderList",list);
        return "redirect:/index/order.jsp";
    }
    @RequestMapping("findAmount")
    public void findAmount(Integer userId,HttpSession session){
        if (userId != null){

            List<Order> order = orderService.findByUserId(userId);
            session.setAttribute("order",order);
        }
    }
    @RequestMapping("save")
    public String save(HttpSession session){
        Order order = (Order)session.getAttribute("order");
        Integer total = order.getTotal();
        Integer amount = order.getAmount();
        Integer status = order.getStatus();
        Integer paytype = order.getPaytype();
        String name = order.getItemList().get(0).getGood().getName();
        Integer uid = order.getUser().getId();
        String phone = order.getUser().getPhone();
        String address = order.getUser().getAddress();
        Date date = new Date();
        orderService.addOrder(total,amount,status,paytype,name,uid,phone,address,date);
        return "redirect:/order/userOrder?id="+uid;
    }
}
