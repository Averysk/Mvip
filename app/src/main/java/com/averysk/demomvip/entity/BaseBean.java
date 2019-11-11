package com.averysk.demomvip.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 基础实体(基类)
 * @author Averies
 * @version 1.0
 * @Date 2019/05/07
 */
public class BaseBean<T> implements Serializable {

    @SerializedName("reqId")
    public long reqId;
    @SerializedName("error")
    public int error;
    @SerializedName("msg")
    public String msg;
    @SerializedName("data")
    public T data;

    public boolean isSuccess() {
        return error == 0;
    }

}
