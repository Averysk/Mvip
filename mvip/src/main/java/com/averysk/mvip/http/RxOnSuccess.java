//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.averysk.mvip.http;

import io.reactivex.functions.Consumer;

/**
 * Created by Averysk
 */
public abstract class RxOnSuccess<T> implements Consumer<T> {
    public RxOnSuccess() {
    }

    @Override
    public void accept(T t) throws Exception {
        this.onSuccess(t);
    }

    public abstract void onSuccess(T var1);
}
