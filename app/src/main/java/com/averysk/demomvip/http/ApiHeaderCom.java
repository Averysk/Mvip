package com.averysk.demomvip.http;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Api头部定义公用参数
 * @author Averysk
 * @date 2019/05/07
 */
public class ApiHeaderCom implements Serializable {

    public static ApiHeaderCom instance;

    public static ApiHeaderCom getInstance() {
        if (instance == null) {
            synchronized (ApiHeaderCom.class) {
                if (instance == null) {
                    instance = new ApiHeaderCom();
                }
            }
        }
        return instance;
    }

    public ApiHeaderCom(){
    }

    /**
     * 平台类型(ANDROID/IOS/MAPP/H5)
     */
    @SerializedName("mt")
    public String mt = "ANDROID";

    /**
     * 产品ID（取值：“2000”对应“vip线上私教”，“3000”对应“vip线上私教(教练端)”）
     */
    @SerializedName("pid")
    public String pid = "2000";

    /**
     * 客户端包名
     */
    @SerializedName("fident")
    public String fident = "";

    /**
     * 客户端版本号
     */
    @SerializedName("sv")
    public String sv = "";

    /**
     * 客户端机型
     */
    @SerializedName("dm")
    public String dm = "";

    /**
     * 固件版本
     */
    @SerializedName("osv")
    public String osv = "";

    /**
     * 分辨率
     */
    @SerializedName("rslt")
    public String rslt = "";

    /**
     * android平台对应取Android_ID, IOS平台对应值取UUID（openidfa）
     */
    @SerializedName("devid")
    public String devid = "";

    /**
     * 网络(UNKNOWN/2G/3G/4G/WIFI)
     */
    @SerializedName("nt")
    public String nt = "WIFI";

    /**
     * 全局会话id ，参数值为上一道口JSON里返回的reqid字段
     */
    @SerializedName("gid")
    public String gid = "";

    /**
     * 当前UTC时间戳，从1970年1月1日0点0分0秒开始到现在的毫秒数
     */
    @SerializedName("timestamp")
    public String timestamp = "";

    /**
     * 1. 将请求参数格式化为“key=value”格式(包括URL里的业务参数及Headers的common解析出来的参数)，如“k1=v1”、“k2=v2”、“k3=v3”;
     * 2. 将格式化好的参数键值对以字典序升序排列后，拼接在一起，“k1=v1&k2=v2&k3=v3”;
     * 3. 在拼接好的字符串末尾追加上应用的Secret Key; 上述字符串的MD5值即为签名的值。
     * 注：各字段值是没有经过urlencode的真实的值来计算
     */
    @SerializedName("sign")
    public String sign = "";

}
