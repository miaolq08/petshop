package com.miao.pojo;

import lombok.Data;

/**
 * <h3>petshop</h3>
 *
 * @author : MLQ
 * @date : 2020-08-10 07:54
 **/
@Data
public class Goods {
    private Integer id;
    private String name;
    private String cover;
    private String image1;
    private String image2;
    private Integer price;
    private String intro;
    private Integer typeId;
    private Type type;
    private Integer stock;
}
