package com.miao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miao.pojo.Items;
import com.miao.pojo.Order;
import com.miao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin(origins = "*")
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
    @ResponseBody
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
        orderService.addOrder(total,amount,status,paytype,name,uid,phone,address);
        return "redirect:/order/userOrder?id="+uid;
    }
    @RequestMapping("findAll")
    @ResponseBody
    public PageInfo<Order> findAll(@RequestParam(defaultValue = "3") Integer pageSize,
                                   @RequestParam(defaultValue = "1")Integer pageNum ){
        PageHelper.startPage(pageNum,pageSize);
        List<Order> list =orderService.findAll();
        PageInfo<Order> orderPageInfo = new PageInfo<>(list);
        return orderPageInfo;
    }
    @RequestMapping("deleteById")
    @ResponseBody
    public void deleteById(Integer id){
        orderService.deleteById(id);
    }

    @RequestMapping("updateOrder")
    @ResponseBody
    public void updateOrder(@RequestBody Order order){
        System.out.println(order);
        orderService.updateOrder(order);
    }
    @RequestMapping("topay")
    public String topay(Integer orderid,HttpSession session){
        Order order= orderService.findByid(orderid);
        session.setAttribute("order",order);
        return "redirect:/index/pay.jsp";
    }
    @RequestMapping("payok")
    public String payok(Integer id){
        Order order = orderService.findByid(id);
        order.setStatus(2);
        orderService.updateOrder(order);
        return "redirect:/index/payok.jsp";
    }

}
