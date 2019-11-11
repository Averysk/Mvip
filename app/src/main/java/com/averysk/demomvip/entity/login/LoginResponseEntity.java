package com.averysk.demomvip.entity.login;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 登录响应实体
 * @author Averies
 * @date 2019/05/08
 */
public class LoginResponseEntity implements Serializable {
    /**
     * 是否需要绑定手机号
     */
    @SerializedName("needBindPhone")
    private boolean needBindPhone;

    /**
     * 是否需要运动测试
     */
    @SerializedName("needSportTest")
    private boolean needSportTest;

    /**
     * 是否是第一次登录
     */
    @SerializedName("firstLogin")
    private boolean firstLogin;

    /**
     * 访问授权令牌
     */
    @SerializedName("token")
    private String token;

    public boolean isNeedBindPhone() {
        return needBindPhone;
    }

    public void setNeedBindPhone(boolean needBindPhone) {
        this.needBindPhone = needBindPhone;
    }

    public boolean isNeedSportTest() {
        return needSportTest;
    }

    public void setNeedSportTest(boolean needSportTest) {
        this.needSportTest = needSportTest;
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
