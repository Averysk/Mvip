//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.averysk.mvip.http;

/**
 * Created by Averysk
 */
public abstract class DefaultOnFail<T extends Throwable> extends RxOnFail<T> {
    public DefaultOnFail() {
    }

    @Override
    public void onLogonFailure(String message) {
        this.onFailed(message);
    }
}
