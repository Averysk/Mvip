//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.averysk.mvip.ui;

import com.blankj.utilcode.util.NetworkUtils;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Averysk
 */
public abstract class BasePresenter<V extends IView> implements IPresenter<V> {
    protected Reference<V> viewRef;
    private CompositeDisposable compositeDisposable;

    public BasePresenter() {
    }

    @Override
    public void attachView(V view) {
        this.viewRef = new WeakReference(view);
    }

    @Override
    public void detachView() {
        this.dispose();
        if (this.viewRef != null) {
            this.viewRef.clear();
            this.viewRef = null;
        }

    }

    public boolean isViewAttached() {
        return this.viewRef != null && this.viewRef.get() != null;
    }

    public V getView() {
        return (V) this.viewRef.get();
    }

    protected void addDisposable(Disposable subscription) {
        if (this.compositeDisposable == null || this.compositeDisposable.isDisposed()) {
            this.compositeDisposable = new CompositeDisposable();
        }

        this.compositeDisposable.add(subscription);
    }

    private void dispose() {
        if (this.compositeDisposable != null) {
            this.compositeDisposable.dispose();
        }

    }

    public boolean checkNetworkConnected() {
        if (NetworkUtils.isConnected()) {
            return true;
        } else {
            if (this.isViewAttached()) {
                this.getView().showFailed(1, "当前网络不可用，请稍后重试");
            }

            return false;
        }
    }
}
