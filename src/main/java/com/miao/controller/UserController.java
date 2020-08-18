package com.miao.controller;

import com.miao.pojo.User;
import com.miao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;


/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-17 20:52
 **/
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("register")
    public ModelAndView register(User user){
        ModelAndView modelAndView = new ModelAndView();
        int i=userService.regist(user);
        if (i>0){
           modelAndView.setViewName("/index/login.jsp");
        }
        else {
            modelAndView.setViewName("/index/register.jsp");
        }
        return modelAndView;

    }
    @RequestMapping("login")
    public String login(User user, HttpSession session){
        User user1=userService.login(user);
        String url =null;
        if (user1 != null){
            session.setAttribute("user1",user1);
            url="/index/index.jsp";
        }else {
            url="/index/login.jsp";
        }
        return "redirect:"+url;
    }
    @RequestMapping("my")
    public String my(String username,HttpSession session){
        System.out.println(username + "username");
        User user=userService.findByName(username);
        session.setAttribute("user",user);
        System.out.println(user);
        return "redirect:/index/my.jsp";


    }
}
