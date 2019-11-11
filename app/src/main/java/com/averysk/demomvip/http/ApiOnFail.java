package com.averysk.demomvip.http;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.averysk.mvip.http.DefaultOnFail;
import com.averysk.mvip.ui.BasePresenter;
import com.averysk.mvip.ui.IView;


/**
 * Api接口请求失败
 * @author Averies
 * @date 2019/05/07
 */
public class ApiOnFail extends DefaultOnFail<Throwable> {

    /**
     * 视图处理
     */
    private BasePresenter<? extends IView> mPresenter;
    /**
     * 返回错误请求码
     */
    private int what;

    public ApiOnFail(@NonNull BasePresenter<? extends IView> presenter) {
        this(presenter, 0);
    }

    public ApiOnFail(@NonNull BasePresenter<? extends IView> presenter, int what) {
        this.mPresenter = presenter;
        this.what = what;
    }

    /**
     * 其他失败处理
     *
     * @param message 信息
     */
    @Override
    public void onFailed(String message) {
        if (mPresenter.isViewAttached()) {
            mPresenter.getView().hideLoading();
            if (!TextUtils.isEmpty(message)){
                mPresenter.getView().showFailed(what, message);
            }
        }
    }

    @Override
    public void onFailed(int code, String message) {
        if (mPresenter.isViewAttached()) {
            mPresenter.getView().hideLoading();
            if (!TextUtils.isEmpty(message)){
                mPresenter.getView().showFailed(code, message);
            }
        }
    }
}
