package com.averysk.demomvip.http;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Api头部定义
 * @author Averysk
 * @date 2019/05/07
 */
public class ApiHeader implements Serializable {

    /**
     * “Bearer ”+ 登录返回的访问授权令牌
     */
    @SerializedName("Authorization")
    public String Api_Token = "";

    /**
     * 全局参数客户端拼成JSON字符串
     */
    @SerializedName("common")
    public ApiHeaderCom Api_Common;
}
