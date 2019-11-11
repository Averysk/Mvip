//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.averysk.mvip.ui;

/**
 * Created by Averysk
 */
public interface IView {
    void showLoading();

    void showLoading(CharSequence tipWord);

    void hideLoading();

    void showFailed(int var1, String var2);
}
