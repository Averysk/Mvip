package com.averysk.demomvip.common;

import android.app.Application;

import com.averysk.mvip.helper.LoggerInterceptor;
import com.averysk.mvip.helper.NoNetworkInterceptor;
import com.averysk.demomvip.helper.TokenHelper;
import com.vise.log.ViseLog;
import com.vise.log.inner.LogcatTree;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.interceptor.HttpLogInterceptor;
import com.vise.xsnow.http.interceptor.NoCacheInterceptor;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 全局定义
 * @author Averies
 * @date 2019/05/07
 */
public class AppContext extends Application {

    public static AppContext INSTANCE;
    public static AppContext getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        initViseLog();
        initViseHttp();
    }

    private void initViseLog() {
        ViseLog.getLogConfig()
                //是否输出日志
                .configAllowLog(true)
                //是否排版显示
                .configShowBorders(true);
        ViseLog.plant(new LogcatTree());//添加打印日志信息到Logcat的树
    }

    private void initViseHttp() {
        ViseHttp.init(INSTANCE);
        ViseHttp.CONFIG()
                //配置请求主机地址
                .baseUrl(AppEnv.BASE_URL_HOST)
                //配置全局请求头
                //.globalHeaders(globalHeaders)
                //配置全局请求参数
                //.globalParams(globalParams)
                //配置读取超时时间，单位秒
                .readTimeout(AppConst.HTTP_TIME_OUT)
                //配置写入超时时间，单位秒
                .writeTimeout(AppConst.HTTP_TIME_OUT)
                //配置连接超时时间，单位秒
                .connectTimeout(AppConst.HTTP_TIME_OUT)
                //配置是否使用cookie
                //.setCookie(true)
                //配置日志拦截器
                .interceptor(new HttpLogInterceptor()
                .setLevel(HttpLogInterceptor.Level.BODY))
                //配置网络拦截器
                .networkInterceptor(new NoCacheInterceptor())
        ;
        ViseHttp.getRetrofitBuilder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        ViseHttp.getOkHttpBuilder()
                .addInterceptor(new NoNetworkInterceptor())
                .addInterceptor(new LoggerInterceptor().setDebug(AppEnv.IS_STACK))
                .addNetworkInterceptor(new NoCacheInterceptor())
                .addNetworkInterceptor(TokenHelper.getInterceptor());

    }

}
