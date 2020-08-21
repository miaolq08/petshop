package com.miao.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-19 19:05
 **/
@Data
public class Order {
    private Integer id;
    private Integer total;
    private Integer amount;
    private Integer status;
    private Integer paytype;
    private String name;
    private String phone;
    private String address;
    private Date systime;
    private User user;
    private List<Items> itemList;
}
