package com.miao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miao.pojo.Json;
import com.miao.pojo.User;
import com.miao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-17 20:52
 **/
@Controller
@RequestMapping("user")
@CrossOrigin(origins = "*")
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
    public String login(User user, HttpSession session, HttpServletResponse response){
        User user1=userService.login(user);

        String url =null;
        if (user1 != null){
            session.setAttribute("user",user1);
            Cookie cookie = new Cookie("loginUser", session.getId());
            cookie.setMaxAge(36000000);
            response.addCookie(cookie);
            url="/index/index.jsp";
        }else {
            url="/index/login.jsp";
        }
        return "redirect:"+url;
    }
    @RequestMapping("my")
    public String my(String username,HttpSession session){

        User user=userService.findByName(username);
        session.setAttribute("user",user);

        return "redirect:/index/my.jsp";
    }
    @RequestMapping("findAll")
    @ResponseBody
    public PageInfo<User> findAll(@RequestParam(defaultValue = "4") Integer pageSize,
                                  @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageSize,pageNum);
        List<User> list = userService.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    @RequestMapping("deleteById")
    @ResponseBody
    public void deleteById(Integer id){
        userService.deleteById(id);
    }
    @RequestMapping("updateUser")
    @ResponseBody
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }
    @RequestMapping("logout")
    public String logout(HttpSession session){

         session.setAttribute("user",null);
        return "redirect:/index/index.jsp";
    }
    @RequestMapping("updateUserB")
    public String updateUserB(User user,String passwordNew){
        User user1 = user;
        user1.setPassword(passwordNew);
        userService.updateUser(user1);
        return "redirect:/index/index.jsp";
    }

}
