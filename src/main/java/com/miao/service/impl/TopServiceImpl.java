package com.miao.service.impl;

import com.miao.dao.TopDao;
import com.miao.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-17 19:46
 **/
@Service
public class TopServiceImpl implements TopService {
    @Autowired
    private TopDao topDao;
    @Override
    public List findTop1() {
        return topDao.findTop1();
    }
}
