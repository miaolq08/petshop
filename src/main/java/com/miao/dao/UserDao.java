package com.miao.dao;

import com.miao.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    int regist(User user);
    User login(User user);

    User findByName(String username);
}
