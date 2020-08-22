package com.miao.controller;

import com.miao.pojo.Goods;
import com.miao.pojo.Items;
import com.miao.pojo.Order;
import com.miao.pojo.User;
import com.miao.service.GoodsService;
import com.miao.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String findByGoodsId(Integer id, Integer userId ,
                                HttpSession session, HttpServletRequest request,
                                HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        Goods good = goodsService.findById(id);
        Items items = new Items();
        items.setGood(good);
        items.setAmount(1);
        items.setPrice(good.getPrice());
        Order order = new Order();
        for (int i = 0; i <cookies.length ; i++) {
            if ("orderCookie".equals(cookies[i].getName())){
                if (session.getId().equals(cookies[i].getValue())){
                    order = (Order) session.getAttribute("order");
                    if (order.getStatus()==1){
                        List<Items> itemList = order.getItemList();
                        itemList.add(items);
                        int sum=0;
                        for (int j = 0; j <itemList.size() ; j++) {
                            sum +=itemList.get(j).getPrice();
                        }
                        order.setItemList(itemList);
                        order.setTotal(sum);
                        order.setAmount(itemList.size());
                        break;
                    }
                }
            }else {
                session.setAttribute("order",order);
                String id1 = session.getId();
                Cookie cookie = new Cookie("orderCookie", id1);
                cookie.setMaxAge(60*60);
                response.addCookie(cookie);
                order = (Order) session.getAttribute("order");
                User user = userService.findById(userId);
                order.setUser(user);
                order.setPaytype(2);//这块不应该写 应该在点击付款方式的时候获取
                order.setStatus(1);
                order.setPhone(user.getPhone());
                order.setAddress(user.getAddress());
                List<Items> itemList =new ArrayList<>();
                itemList.add(items);
                order.setItemList(itemList);
                order.setAmount(items.getAmount());
                order.setTotal(good.getPrice());
            }
            session.setAttribute("order",order);
        }



       // orderService.addOrder(order);
        /*List<Order> orders = orderService.findByUserId(userId);*/
       // itemsService.addItems(items);

        return "redirect:/index/cart.jsp";
    }
    @RequestMapping("add")
    @ResponseBody
    public void add(Integer id,HttpSession session){
        Order order = (Order)session.getAttribute("order");
        List<Items> itemList = order.getItemList();
        Integer price = 0;
        for (int i = 0; i <itemList.size() ; i++) {
            if (id == itemList.get(i).getGood().getId()){
                price = itemList.get(i).getGood().getPrice();
                Integer amount = itemList.get(i).getAmount();
                itemList.get(i).setAmount(amount+1);
                //设置 一个item新价格
                itemList.get(i).setPrice(itemList.get(i).getAmount()*price);
                order.setItemList(itemList);
                break;
            }
        }
        //设置订单的总价格
        int num = order.getTotal()+price;
        order.setTotal(num);
        session.setAttribute("order",order);

    }
    @RequestMapping("sub")
    @ResponseBody
    public void sub(Integer id){


    }
    @RequestMapping("del")
    @ResponseBody
    public void del(Integer id){

    }
}
