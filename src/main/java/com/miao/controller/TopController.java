package com.miao.controller;

import com.miao.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-17 19:37
 **/
@RestController
@RequestMapping("top")
public class TopController {
    @Autowired
    private TopService topService;
    @RequestMapping("findTop2")
    public void findTop1(HttpSession session){
        List top =topService.findTop1();
        session.setAttribute("top2List",top);
    }


}
