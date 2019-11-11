package com.averysk.demomvip.base;

import com.averysk.demomvip.common.AppComContract;
import com.averysk.demomvip.common.AppComPresenter;
import com.averysk.mvip.base.BaseVIPFragment;

/**
 * 基类(自定义继承式共享标题栏)
 * @author Averysk
 * @date 2019/05/07
 */
public abstract class BaseComVIPFragment extends BaseVIPFragment<AppComContract.CommonPresenter> implements AppComContract.CommonView {

    @Override
    public AppComContract.CommonPresenter createPresenter() {
        return AppComPresenter.getInstance();
    }

    public AppComContract.CommonPresenter getCommonPresenter(){
        return this.getPresenter();
    }

}
