package com.averysk.demomvip.helper;

import java.util.UUID;

/**
 * 用户管理类
 * @author  Averysk
 * @data 2019/05/08
 */
public class UserHelper {

    public static final String USER_INFO = "USER_INFO";
    public static final String IS_LOGIN = "IS_LOGIN";
    public static final String API_HEADER = "API_HEADER";
    public static final String IS_IN_GROUP = "IS_IN_GROUP";

    public static void createUUID() {
        SPHelper.setUuidLocal(UUID.randomUUID().toString().replaceAll("-", ""));
    }

    public static String getUUID() {
        return SPHelper.getUuidLocal();
    }

    public static void setToken(String token) {
        SPHelper.setUserTokene(token);
    }

    public static String getToken() {
        return SPHelper.getUserTokene();
    }

    public static void setReqId(String reqId) {
        SPHelper.setUserReqId(reqId);
    }

    public static String getReqId() {
        return SPHelper.getUserReqId();
    }



/*
    public static UserInfoEntity getUser() {
        return GsonUtil.gson().fromJson(SPHelper.getInstance().getString(USER_INFO), UserInfoEntity.class);
    }

    public static boolean isLogin() {
        return SPHelper.getInstance().getBoolean(IS_LOGIN);
    }

    public static void saveUser(UserInfoEntity user) {
        SPHelper.getInstance().putString(USER_INFO, GsonUtil.gson().toJson(user));
        SPHelper.getInstance().putBoolean(IS_LOGIN, true);
        setIsInGroup(user);
        addTokenMap(user);
    }

    public static void logout() {
        SPHelper.getInstance().putString(USER_INFO, "");
        SPHelper.getInstance().putBoolean(IS_LOGIN, false);
    }

    private static void addTokenMap(UserInfoEntity user) {
        if (user != null){
            // 第一种缓存方式
            ApiHeader apiHeader = new ApiHeader();
            apiHeader.API_User_Token = user.getUserToken();
            apiHeader.User_Id = user.getUserId() + "";
            apiHeader.APP_Platform = "2";
            apiHeader.APP_Version = AppInfoUtil.getLocalVersionName(AppContext.getAppContext());
            SPHelper.getInstance().putString(API_HEADER, GsonUtil.gson().toJson(apiHeader));
            // 第二种缓存方式
            SPHelper.setUserTokene(user.getUserToken());
            SPHelper.setUserId(user.getUserId() + "");
            SPHelper.setAppPlatform("2");
            SPHelper.setAppVersion(AppInfoUtil.getLocalVersionName(AppContext.getAppContext()));
        }
    }


    public static Map<String, String> getHeaderMap() {
        ApiHeader apiHeader = GsonUtil.gson().fromJson(SPHelper.getInstance().getString(API_HEADER), ApiHeader.class);
        Map<String, String> headerMap = new HashMap<>();
        if (apiHeader != null){
            headerMap.clear();
            headerMap.put("API-User-Token",apiHeader.API_User_Token);
            headerMap.put("User-Id",apiHeader.User_Id);
            headerMap.put("APP-Platform",apiHeader.APP_Platform);
            headerMap.put("APP-Version",apiHeader.APP_Version);
        } else {
            headerMap.clear();
            headerMap.put("API-User-Token", SPHelper.getUserTokene());
            headerMap.put("User-Id", SPHelper.getUserId());
            headerMap.put("APP-Platform", SPHelper.getAppPlatform());
            headerMap.put("APP-Version", SPHelper.getAppVersion());
        }
        return headerMap;
    }


    public static void setIsInGroup(UserInfoEntity user) {
        if (user.getIsInGroup() == 2){
            SPHelper.getInstance().putBoolean(IS_IN_GROUP, false);
        } else {
            SPHelper.getInstance().putBoolean(IS_IN_GROUP, true);
        }
    }

    public static void setIsInGroup(boolean flag) {
        SPHelper.getInstance().putBoolean(IS_IN_GROUP, flag);
    }

    public static boolean getIsInGroup() {
        return SPHelper.getInstance().getBoolean(IS_IN_GROUP);
    }
*/
}
