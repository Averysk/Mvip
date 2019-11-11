package com.averysk.demomvip.helper;

import com.averysk.demomvip.http.ApiHeaderCom;
import com.vise.xsnow.common.GsonUtil;

import java.util.HashMap;

public class ApiHelper {

    public static HashMap<String, String> headerMap;

    public static HashMap<String, String> getHeaderMap() {
        if (headerMap != null){
            headerMap.clear();
            headerMap = null;
        }
        headerMap = new HashMap<>();
        headerMap.put("Authorization", UserHelper.getToken());
        ApiHeaderCom apiHeaderCom = ApiHeaderCom.getInstance();
        apiHeaderCom.nt = "";
        apiHeaderCom.gid = UserHelper.getReqId();
        apiHeaderCom.timestamp = String.valueOf(System.currentTimeMillis());
        apiHeaderCom.sign = "";
        headerMap.put("common", GsonUtil.gson().toJson(apiHeaderCom));

        return headerMap;
    }

}
