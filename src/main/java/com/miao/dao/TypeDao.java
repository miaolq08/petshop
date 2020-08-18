package com.miao.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-10 07:59
 **/
@Repository
public interface TypeDao {
    List findAll();
}
