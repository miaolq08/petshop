package com.miao.pojo;

import lombok.Data;

@Data
public class Json<T> {

    private T data;
    private String code;
    private String msg;
    private long count;

    /**
     * 若没有数据返回，默认状态码为 0，提示信息为“操作成功！”
     */
    public Json() {
        this.code = "0";
        this.msg = "操作成功！";
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     *
     * @param code
     * @param msg
     */
    public Json(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有数据返回时，状态码为 0，默认提示信息为“操作成功！”
     *
     * @param data
     */
    public Json(T data) {
        this.data = data;
        this.code = "0";
        this.msg = "操作成功！";
    }

    /**
     * 有数据返回，状态码为 0，人为指定提示信息
     *
     * @param data
     * @param msg
     */
    public Json(T data, String msg) {
        this.data = data;
        this.code = "0";
        this.msg = msg;
    }
    public Json(long count,T data) {
        this.data = data;
        this.count =count;
        this.code = "0";
        this.msg = "操作成功！";
    }

}