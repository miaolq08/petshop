package com.miao.controller;

import com.miao.service.TypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class TypeController {
    @Autowired
    private TypeServices typeServices;
    @RequestMapping("findAll")
    public String findAll(HttpSession session){
        List typeList = typeServices.findAll();
        session.setAttribute("typeList",typeList);
        return "redirect:/index/index.jsp";
    }
}
