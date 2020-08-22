package com.miao.dao;

import com.miao.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    int regist(User user);
    User login(User user);

    User findByName(String username);

    List<User> findAll();

    void deleteById(Integer id);

    void updateUser(User user);

    User findById(Integer id);

}
