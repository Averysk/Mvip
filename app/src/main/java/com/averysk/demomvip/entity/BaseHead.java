package com.averysk.demomvip.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 基础实体(头部)
 * @author Averies
 * @version 1.0
 * @Date 2019/05/07
 */
public class BaseHead<T> extends BaseEntity{

    @SerializedName("reqId")
    public int reqId;
    @SerializedName("error")
    public int error;
    @SerializedName("msg")
    public String msg;

    public boolean isSuccess() {
        return error == 0;
    }

}
