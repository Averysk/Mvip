//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.averysk.mvip.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.averysk.mvip.ui.IPresenter;
import com.averysk.mvip.ui.IView;

/**
 * 基类(自定义MVIP设计模式)
 * @author Averies
 * @date 2019/05/07
 */
public abstract class BaseVIPActivity<P extends IPresenter> extends MySupportActivity implements IView {
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.beforeOnCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        this.afterOnCreate(savedInstanceState);
        if (this.getLayoutId() != 0) {
            this.setContentView(this.getLayoutId());
        }
        this.presenter = this.createPresenter();
        if (this.getPresenter() != null) {
            this.getPresenter().attachView(this);
        }
        this.initData(savedInstanceState);
        this.initData();
        this.initView(savedInstanceState);
        this.initView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.saveData(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.getPresenter() != null){
            this.getPresenter().detachView();
        }
    }

    /**
     * 在创建之前的启用扩展支持方法
     * @param savedInstanceState
     */
    protected void beforeOnCreate(@Nullable Bundle savedInstanceState) {
        this.supportRequestWindowFeature(1);
    }

    /**
     * 在创建之后的启用扩展支持方法
     * @param savedInstanceState
     */
    protected void afterOnCreate(@Nullable Bundle savedInstanceState){}

    /**
     * 设置当前布局资源Id
     * @return
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 创建当前控制者
     * @return
     */
    protected abstract P createPresenter();

    /**
     * 获取当前控制者
     * @return
     */
    public P getPresenter() { return this.presenter;}

    /**
     * 初始化数据
     * @param savedInstanceState
     */
    protected void initData(Bundle savedInstanceState){}

    /**
     * 初始化数据
     */
    protected void initData(){}

    /**
     * 初始化视图
     * @param savedInstanceState
     */
    protected void initView(Bundle savedInstanceState){}

    /**
     * 初始化视图
     */
    protected void initView(){}

    /**
     * 缓存数据
     * @param outState
     */
    protected void saveData(Bundle outState){};

    /**
     * 显示正在加载中....
     */
    @Override
    public void showLoading(){};

    /**
     * 显示自定义提示标语
     */
    @Override
    public void showLoading(CharSequence tipWord){}

    /**
     * 隐藏提示标语
     */
    @Override
    public void hideLoading(){}

    /**
     * 显示消息
     * @param what
     * @param message
     */
    @Override
    public void showFailed(int what, String message){}
}
