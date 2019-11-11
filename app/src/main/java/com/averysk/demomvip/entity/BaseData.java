package com.averysk.demomvip.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 基础实体(数据)
 * @author Averies
 * @version 1.0
 * @Date 2019/05/07
 */
public class BaseData<T>  extends BaseBean{

    @SerializedName("data")
    public T data;
}
