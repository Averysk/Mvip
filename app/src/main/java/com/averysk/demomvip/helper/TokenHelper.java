package com.averysk.demomvip.helper;

import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * token的拦截器
 * Created by Averysk on 2019/05/08.
 */
public class TokenHelper {

    private static final String AUTHORIZATION = "Authorization";

    public static Interceptor getInterceptor() {
        return chain -> {
            Request originalRequest = chain.request();
            if (UserHelper.getToken() == null || UserHelper.getToken().isEmpty()) {
                return chain.proceed(originalRequest);
            }
            Request authorised = originalRequest.newBuilder()
                    .header(AUTHORIZATION, "Bearer" + " " + UserHelper.getToken())
                    .build();
            return chain.proceed(authorised);
        };
    }
}