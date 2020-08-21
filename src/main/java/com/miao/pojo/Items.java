package com.miao.pojo;

import com.miao.pojo.Goods;
import com.miao.pojo.Order;
import lombok.Data;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-19 19:50
 **/
@Data
public class Items {
    private Integer id;
    private Integer price;
    private Integer amount;
    private Order order;
    private Goods good;
}
