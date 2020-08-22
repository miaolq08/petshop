package com.miao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miao.pojo.Type;
import com.miao.service.TypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-10 07:58
 **/
@Controller
@RequestMapping("type")
@CrossOrigin(origins = "*")
public class TypeController {
    @Autowired
    private TypeServices typeServices;
    @RequestMapping("findAll")
    public String findAll(HttpSession session){
        List typeList = typeServices.findAll();
        session.setAttribute("typeList",typeList);
        return "redirect:/index/index.jsp";
    }
    @RequestMapping("findByPage")
    @ResponseBody
    public PageInfo<Type> findByPage(@RequestParam(defaultValue = "2")Integer pagesize,
                                     @RequestParam(defaultValue = "1")Integer pageNum){
        PageHelper.startPage(pageNum,pagesize);
        List all = typeServices.findAll();
        PageInfo<Type> typePageInfo = new PageInfo<Type>(all);
        return typePageInfo;
    }
    @RequestMapping("addType")
    @ResponseBody
    public void addType(@RequestBody Type type){
        System.out.println(type);
        typeServices.add(type);

    }
    @RequestMapping("updateType")
    @ResponseBody
    public void updateType(@RequestBody Type type){
        typeServices.updateType(type);

    }
    @RequestMapping("deleteById")
    @ResponseBody
    public void deleteById(@RequestBody Integer id){
        typeServices.deleteById(id);

    }

}
