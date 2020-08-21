package com.miao.controller;

import com.miao.pojo.Admin;
import com.miao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-20 20:28
 **/
@Controller
@RequestMapping("admin")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("login")
    public String login(Admin admin){
        Admin admin1= adminService.login(admin);
        if (admin1 == null){
            return "redirect:/admin/login.jsp";
        }else {
            return "redirect:/admin/jump.jsp";
        }
    }
}
