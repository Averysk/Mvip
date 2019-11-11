package com.averysk.mvip.base;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;

import com.averysk.mvip.ui.IPresenter;
import com.averysk.mvip.ui.IView;

/**
 * 基类(自定义MVIP设计模式)
 * @author Averies
 * @date 2019/05/07
 */
public abstract class BaseVIPFragment<P extends IPresenter> extends MySupportFragment implements IView {
    protected P presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int theme = this.getThemeRes();
        View rootView;
        if (theme == -1) {
            rootView = inflater.inflate(this.getLayoutId(), container, false);
        } else {
            Context contextThemeWrapper = new ContextThemeWrapper(this.getActivity(), theme);
            LayoutInflater layoutInflater = inflater.cloneInContext(contextThemeWrapper);
            rootView = layoutInflater.inflate(this.getLayoutId(), container, false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.presenter = this.createPresenter();
        if (this.getPresenter() != null) {
            this.getPresenter().attachView(this);
        }
        this.beforeInit(view, savedInstanceState);
        this.beforeInit();
        this.initData(view, savedInstanceState);
        this.initData();
        this.initView(view, savedInstanceState);
        this.initView();
        hideSoftInput();
    }

    @Override
    public void onEnterAnimationEnd(Bundle savedInstanceState) {
        super.onEnterAnimationEnd(savedInstanceState);
        this.loadData(savedInstanceState);
        this.loadData();
    }

    @Override
    public void onDestroyView() {
        if (this.getPresenter() != null) {
            this.getPresenter().detachView();
        }
        super.onDestroyView();
    }

    /**
     * 设置当前主题资源Id
     * @return
     */
    @StyleRes
    protected int getThemeRes() {
        return -1;
    }

    /**
     * 设置当前布局资源Id
     * @return
     */
    @LayoutRes
    public abstract int getLayoutId();

    /**
     * 创建当前控制者
     * @return
     */
    public abstract P createPresenter();

    /**
     * 获取当前控制者
     * @return
     */
    public P getPresenter() {
        return this.presenter;
    }

    /**
     * 在初始化之前的启用扩展支持方法
     * @param view
     * @param savedInstanceState
     */
    protected void beforeInit(@NonNull View view, @Nullable Bundle savedInstanceState) {}

    /**
     * 在初始化之前的启用扩展支持方法
     */
    protected void beforeInit() {}

    /**
     * 初始化数据
     * @param view
     * @param savedInstanceState
     */
    protected void initData(@NonNull View view, @Nullable Bundle savedInstanceState) {}

    /**
     * 初始化数据
     */
    protected void initData() {}

    /**
     * 初始化视图
     * @param view
     * @param savedInstanceState
     */
    protected void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {}

    /**
     * 初始化视图
     */
    protected void initView() {}

    /**
     * 加载数据
     * @param savedInstanceState
     */
    protected void loadData(@Nullable Bundle savedInstanceState) {}

    /**
     * 加载数据
     */
    protected void loadData() {}

    /**
     * 显示正在加载中....
     */
    @Override
    public void showLoading() {}

    /**
     * 显示自定义提示标语
     */
    @Override
    public void showLoading(CharSequence tipWord) {}

    /**
     * 隐藏提示标语
     */
    @Override
    public void hideLoading() {}

    /**
     * 显示消息
     *
     * @param what
     * @param message
     */
    @Override
    public void showFailed(int what, String message) {}

}
