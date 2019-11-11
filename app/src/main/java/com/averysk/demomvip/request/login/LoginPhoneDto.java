package com.averysk.demomvip.request.login;

/**
 * 手机登录
 * @author Averies
 */
public class LoginPhoneDto {
    /**
     * 手机号
     */
    public String phone;

    /**
     * 短信验证码
     */
    public String code;

    /**
     * 推广渠道来源(待定义)
     */
    public int from;

}
