package com.averysk.demomvip.http;

import com.averysk.demomvip.entity.BaseBean;
import com.averysk.mvip.exception.LocalOperException;
import com.averysk.demomvip.helper.UserHelper;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

/**
 * Api接口回调
 * @author Averysk
 * @date 2019/05/07
 */
public class ApiResponse {

    public static <T> ObservableTransformer<BaseBean<T>, T> handleResult() {
        return upstream -> {
            Function<BaseBean<T>, ObservableSource<T>> function = result -> {
                // 默认保存全局会话id ，参数值为上一道口JSON里返回的reqid字段
                UserHelper.setReqId(String.valueOf(result.reqId));
                // 判断结果如果是异常就转到error方法中
                if (result.isSuccess()) {
                    return createData(result.data);
                } else {
                    return Observable.error(new LocalOperException(result.error, result.msg));
                }
            };
            return upstream.flatMap(function);
        };
    }

    public static <T> ObservableTransformer<BaseBean<T>, BaseBean<T>> handleResultNull() {
        return upstream -> {
            Function<BaseBean<T>, ObservableSource<BaseBean<T>>> function;
            function = responseBean -> {
                // 默认保存全局会话id ，参数值为上一道口JSON里返回的reqid字段
                UserHelper.setReqId(String.valueOf(responseBean.reqId));
                // 判断结果如果是异常就转到error方法中
                if (responseBean.isSuccess()) {
                    return createData(responseBean);
                } else {
                    return Observable.error(new LocalOperException(responseBean.error, responseBean.msg));
                }
            };
            return upstream.flatMap(function);
        };
    }

    private static <T> Observable<T> createData(T t) {
        return Observable.create((subscriber) -> {
            try {
                subscriber.onNext(t);
                subscriber.onComplete();
            } catch (Exception var3) {
                subscriber.onError(var3);
            }
        });
    }

}
