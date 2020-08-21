package com.miao.service.impl;

import com.miao.dao.AdminDao;
import com.miao.pojo.Admin;
import com.miao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-20 21:01
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin login(Admin admin) {
       return adminDao.login(admin);
    }
}
