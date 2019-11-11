package com.averysk.demomvip.common;

import com.averysk.demomvip.entity.login.LoginResponseEntity;
import com.averysk.demomvip.request.login.LoginPhoneDto;
import com.averysk.mvip.ui.IPresenter;
import com.averysk.mvip.ui.IView;

/**
 * 基类(IV与IP绑定)
 * @author Averysk
 * @date 2019/05/07
 */
public interface AppComContract {

    interface CommonView extends IView {

        default void onCountDownStart(){};

        default void onCountingDown(long remain){};

        default void onCountDownCompleted(){};

        default void sendCodeSuccess(){};

        default void loginPhoneSuccess(LoginResponseEntity entity){};
    }

    interface CommonPresenter extends IPresenter<CommonView> {

        default void getValCode(String mobile){};

        default void loginPhone(LoginPhoneDto dto){};
    }


}
