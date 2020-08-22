package com.miao.controller;

import com.miao.pojo.Goods;
import com.miao.pojo.Items;
import com.miao.pojo.Order;
import com.miao.pojo.User;
import com.miao.service.GoodsService;
import com.miao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-19 19:47
 **/
@RequestMapping("items")
@Controller
public class ItemsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;
    @RequestMapping("addByGoodsId")
    public String findByGoodsId(Integer id,Integer userId ,HttpSession session){
        Goods good = goodsService.findById(id);
        Order order = new Order();
        User user = userService.findById(userId);
        order.setUser(user);
        order.setPaytype(2);//这块不应该写 应该在点击方式的时候获取
        order.setStatus(1);
        order.setPhone(user.getPhone());
        order.setAddress(user.getAddress());
        List<Items> itemList =new ArrayList<>();
        Items items = new Items();
        items.setGood(good);
        items.setAmount(1);
        items.setPrice(good.getPrice());
        order.setTotal(good.getPrice());
        itemList.add(items);
        order.setItemList(itemList);
        order.setAmount(items.getAmount());
       // orderService.addOrder(order);
        /*List<Order> orders = orderService.findByUserId(userId);*/
       // itemsService.addItems(items);
        session.setAttribute("order",order);
        return "redirect:/index/cart.jsp";
    }
}
