package com.miao.service.impl;

import com.miao.dao.UserDao;
import com.miao.pojo.User;
import com.miao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-17 20:58
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int regist(User user) {
        return userDao.regist(user);
    }

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }
}
