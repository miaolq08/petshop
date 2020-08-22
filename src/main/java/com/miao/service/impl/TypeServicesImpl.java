package com.miao.service.impl;

import com.miao.dao.TypeDao;
import com.miao.pojo.Type;
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

    @Override
    public void add(Type type) {
        typeDao.add(type);
    }

    @Override
    public void updateType(Type type) {
        typeDao.updateType(type);
    }

    @Override
    public void deleteById(Integer id) {
        typeDao.deleteById(id);
    }
}
