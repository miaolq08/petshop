package com.miao.dao;

import com.miao.pojo.Items;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-19 19:53
 **/
@Repository
public interface ItemsDao {
    void addItems(Items items);
}
