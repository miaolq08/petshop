package com.miao.service;

import com.miao.pojo.Type;

import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-10 07:59
 **/
public interface TypeServices {
    List findAll();

    void add(Type type);

    void updateType(Type type);

    void deleteById(Integer id);
}
