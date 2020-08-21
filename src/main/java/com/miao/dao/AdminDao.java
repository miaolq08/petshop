package com.miao.dao;

import com.miao.pojo.Admin;
import org.springframework.stereotype.Repository;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-20 21:03
 **/
@Repository
public interface AdminDao {
    Admin login(Admin admin);
}
