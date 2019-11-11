package com.averysk.demomvip.common;

/**
 * 全局定义参数
 * @author Averies
 * @date 2019/05/07
 */
public class AppEnv {

    /**
     * 是否是测试环境
     */
    public static final boolean IS_DEBUG = true;
    public static final boolean IS_STACK = false;
    public static final String BASE_URL_HOST;
    public static final String WXAPI_APP_ID;

    public static final String END_POINT;
    public static final String ACCESS_KEY_ID;
    public static final String ACCESS_KEY_SECRET;
    public static final String BUCKET_NAME;
    // @see IM库 Constants
    public static final int ACCOUNT_TYPE;
    public static final int SDK_APPID;


    static {
        if (IS_DEBUG) {
            //BASE_URL_HOST = "http://192.168.31.74:8080/vipcourse/user/";
            BASE_URL_HOST = "http://139.224.135.76:8080/vipcourse/user/";
            WXAPI_APP_ID = "wxb570c41b1fa2ffe3";

            END_POINT = "http://oss-cn-hangzhou.aliyuncs.com";
            ACCESS_KEY_ID = "J3GrHuykogVUbRJe";
            ACCESS_KEY_SECRET = "AMtN9srzPJCjQ7SNHkaQpX9MY4nBKz";
            BUCKET_NAME = "blackboard-develop-bucket";
            ACCOUNT_TYPE = 22126;
            SDK_APPID = 1400065611;
        } else {
            BASE_URL_HOST = "http://api.fnbell.tech/";
            WXAPI_APP_ID = "wxb570c41b1fa2ffe3";


            END_POINT = "http://oss-cn-shanghai.aliyuncs.com";
            ACCESS_KEY_ID = "LTAIX5vxCXEBSLyU";
            ACCESS_KEY_SECRET = "JtVA3DwxJyoKFgldp4OQCUDuNIcO2O";
            BUCKET_NAME = "fndz-pd";
            ACCOUNT_TYPE = 22126;
            SDK_APPID = 1400065611;
        }
    }
}
