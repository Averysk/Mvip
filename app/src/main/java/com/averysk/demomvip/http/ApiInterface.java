package com.averysk.demomvip.http;

import com.averysk.demomvip.entity.BaseBean;
import com.averysk.demomvip.entity.BaseEntity;
import com.averysk.demomvip.entity.login.LoginResponseEntity;
import com.averysk.demomvip.request.login.LoginPhoneDto;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Api接口请求
 * @author Averies
 * @date 2019/05/07
 */
public interface ApiInterface {

    /**
     * 发送验证码短信
     */
    @GET("valcode")
    Observable<BaseBean<BaseEntity>> getValCode(@HeaderMap Map<String, String> header,
                                                @Query("phone") String phone);

    /**
     * 验证码登录
     */
    @POST("loginbycode")
    Observable<BaseBean<LoginResponseEntity>> loginPhone(@HeaderMap Map<String, String> header,
                                                         @Body() LoginPhoneDto dto);

}
