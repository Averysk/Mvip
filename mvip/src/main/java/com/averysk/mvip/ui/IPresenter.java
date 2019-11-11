//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.averysk.mvip.ui;

/**
 * Created by Averysk
 */
public interface IPresenter<V extends IView> {
    void attachView(V var1);

    void detachView();
}
