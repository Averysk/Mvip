package com.averysk.demomvip.common;


import com.averysk.demomvip.entity.BaseBean;
import com.averysk.demomvip.entity.BaseEntity;
import com.averysk.demomvip.entity.login.LoginResponseEntity;
import com.averysk.mvip.event.RxScheduler;
import com.averysk.demomvip.helper.ApiHelper;
import com.averysk.demomvip.helper.UserHelper;
import com.averysk.demomvip.http.ApiInterface;
import com.averysk.demomvip.http.ApiOnFail;
import com.averysk.demomvip.http.ApiResponse;
import com.averysk.mvip.http.RxOnSuccess;
import com.averysk.demomvip.request.login.LoginPhoneDto;
import com.averysk.mvip.ui.BasePresenter;
import com.vise.xsnow.http.ViseHttp;


/**
 * 基类(IV与IP绑定)
 * @author Averies
 * @date 2019/05/07
 */
public class AppComPresenter extends BasePresenter<AppComContract.CommonView> implements AppComContract.CommonPresenter {

    public static AppComPresenter getInstance() {
        return InstanceHolder.instance;
    }

    private static class InstanceHolder {
        private final static AppComPresenter instance = new AppComPresenter();
    }

    /**
     * 发送获取验证码
     * @param phone
     */
    @Override
    public void getValCode(String phone) {
        ViseHttp.RETROFIT()
                .create(ApiInterface.class)
                .getValCode(ApiHelper.getHeaderMap(), phone)
                .compose(ApiResponse.handleResultNull())
                .compose(RxScheduler.toUiThread())
                .doOnSubscribe(this::addDisposable)
                .subscribe(new RxOnSuccess<BaseBean<BaseEntity>>() {
                    @Override
                    public void onSuccess(BaseBean<BaseEntity> s) {
                        if (isViewAttached()) {
                            getView().hideLoading();
                            getView().sendCodeSuccess();
                        }
                    }
                }, new ApiOnFail(this));
    }

    /**
     * 手机短信验证码登录
     * @param loginPhoneDto
     */
    @Override
    public void loginPhone(LoginPhoneDto loginPhoneDto) {
        ViseHttp.RETROFIT()
                .create(ApiInterface.class)
                .loginPhone(ApiHelper.getHeaderMap(), loginPhoneDto)
                .compose(ApiResponse.handleResult())
                .compose(RxScheduler.toUiThread())
                .doOnSubscribe(this::addDisposable)
                .subscribe(new RxOnSuccess<LoginResponseEntity>() {
                    @Override
                    public void onSuccess(LoginResponseEntity s) {
                        if (isViewAttached()) {
                            // 保存Token信息
                            UserHelper.setToken(s.getToken());
                            getView().hideLoading();
                            getView().loginPhoneSuccess(s);
                        }
                    }
                }, new ApiOnFail(this));
    }

}
