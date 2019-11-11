//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.averysk.mvip.helper;


import androidx.annotation.NonNull;

import com.averysk.mvip.exception.NoNetworkException;
import com.blankj.utilcode.util.NetworkUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Averysk
 */
public class NoNetworkInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        if (!NetworkUtils.isConnected()) {
            throw new NoNetworkException("当前网络不可用，请稍后重试");
        } else {
            return chain.proceed(chain.request());
        }
    }
}
