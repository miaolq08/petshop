package com.miao.service;

import com.miao.pojo.User;

import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-17 20:55
 **/
public interface UserService {
    int regist(User user);

    User login(User user);

    User findByName(String username);

    List<User> findAll();

    void deleteById(Integer id);

    void updateUser(User user);
}
