package com.miao.service.impl;

import com.miao.dao.TypeDao;
import com.miao.service.TypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-10 07:59
 **/
@Service
public class TypeServicesImpl implements TypeServices {
    @Autowired
    private TypeDao typeDao;
    @Override
    public List findAll() {
        return typeDao.findAll();
    }
}
