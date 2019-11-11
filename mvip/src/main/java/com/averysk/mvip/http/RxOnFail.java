//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.averysk.mvip.http;

import com.averysk.mvip.exception.HttpException;
import com.averysk.mvip.exception.LocalOperException;
import com.averysk.mvip.exception.LogonFailureException;
import com.averysk.mvip.exception.NoNetworkException;
import com.blankj.utilcode.util.LogUtils;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.functions.Consumer;

/**
 * Created by Averysk
 */
public abstract class RxOnFail<T extends Throwable> implements Consumer<T> {
    public RxOnFail() {
    }

    @Override
    public void accept(T t) throws Exception {
        if (t instanceof LogonFailureException) {
            LogUtils.e(new Object[]{"登录失效"});
            this.onLogonFailure(t.getMessage());
        } else if (t instanceof NoNetworkException) {
            LogUtils.e(new Object[]{"当前网络不可用"});
            this.onFailed("当前网络不可用，请稍后重试");
        } else if (t instanceof HttpException) {
            LogUtils.e(new Object[]{"服务器返回错误"});
            this.onFailed(t.getMessage());
        } else if (t instanceof LocalOperException) {
            String s = " ErrorCode : " + ((LocalOperException) t).getCode() +" : "+ t.getMessage();
            LogUtils.e(new Object[]{s});
            this.onFailed(((LocalOperException) t).getCode(), t.getMessage());
        } else {
            if (t instanceof SocketTimeoutException) {
                LogUtils.e(new Object[]{"链接超时"});
            } else if (t instanceof ConnectException) {
                LogUtils.e(new Object[]{"链接异常"});
            } else if (t instanceof JsonSyntaxException) {
                LogUtils.e(new Object[]{"Gson内部解析错误"});
            } else if (t instanceof JSONException) {
                LogUtils.e(new Object[]{"Json解析错误"});
            } else if (t instanceof IOException) {
                LogUtils.e(new Object[]{"IO解析错误"});
            } else if (t instanceof Exception) {
                LogUtils.e(new Object[]{"请求失败,其他异常"});
            }

            LogUtils.d(new Object[]{t.toString()});
            this.onFailed("请求失败，请稍后重试");
        }
    }

    public abstract void onLogonFailure(String var1);

    public abstract void onFailed(String var1);

    public abstract void onFailed(int code, String message);
}
