package com.miao.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-17 19:47
 **/
@Repository
public interface TopDao {
    List findTop1();
}
