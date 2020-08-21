package com.miao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miao.pojo.Goods;
import com.miao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-15 17:59
 **/
@Controller
@RequestMapping("goods")
@CrossOrigin(origins="*")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("findAll")
    @ResponseBody
    public PageInfo<Goods> findAll(@RequestParam(defaultValue = "5") Integer pageSize,
                                   @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> list=goodsService.findAll();
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(list);
        return goodsPageInfo;
    }
    @RequestMapping("detail")
    public String findById(Integer goodid, HttpSession session){
       Goods goods=goodsService.findById(goodid);
       session.setAttribute("good",goods);
        return "redirect:/index/detail.jsp";
    }
    @RequestMapping("findByType")
    public String findByType(Integer typeid,HttpSession session){
        List<Goods> goods=goodsService.findByTypeId(typeid);
        session.setAttribute("goodList",goods);
        return "redirect:/index/goods.jsp";
    }
    @RequestMapping("deleteById")
    @ResponseBody
    public void deleteById(Integer id){
        goodsService.deleteById(id);
    }
    @RequestMapping("addGoods")
    @ResponseBody
    public void addGoods(@RequestBody Goods goods){
        goodsService.addGoods(goods);
    }
    @RequestMapping("updateGoods")
    @ResponseBody
    public void updateGoods(@RequestBody Goods goods){
        goodsService.updateGoods(goods);
    }

}
