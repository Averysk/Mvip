//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.averysk.mvip.helper;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.LogUtils;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * Created by Averysk
 */
public class LoggerInterceptor implements Interceptor {
    private boolean isDebug = true;

    public LoggerInterceptor setDebug(boolean isDebug) {
        this.isDebug = isDebug;
        return this;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        if (this.isDebug) {
            this.logForRequest(request);
            response = this.logForResponse(response);
        }

        return response;
    }

    private void logForRequest(Request request) {
        StringBuilder builder = new StringBuilder("---------------------request log start---------------------");

        try {
            String url = request.url().toString();
            Headers headers = request.headers();
            builder.append("\n").append("method : ").append(request.method());
            builder.append("\n").append("url : ").append(url);
            builder.append("\n").append("headers : ");
            if (headers != null && headers.size() > 0) {
                builder.append("\n").append(headers.toString());
            }

            RequestBody requestBody = request.body();
            if (requestBody != null) {
                MediaType mediaType = requestBody.contentType();
                if (mediaType == null) {
                    return;
                }

                builder.append("\n").append("contentType : ").append(mediaType.toString());
                if (this.isText(mediaType)) {
                    builder.append("\n").append("content : ").append(this.bodyToString(request));
                } else {
                    builder.append("\n").append("content : maybe [file part] , too large too print , ignored!");
                }

                return;
            }
        } catch (Exception var10) {
            builder.append("\n").append("error : ").append(var10.toString());
            return;
        } finally {
            builder.append("\n").append("---------------------request log end-----------------------");
            LogUtils.d(new Object[]{builder.toString()});
        }

    }

    private Response logForResponse(Response response) {
        StringBuilder builder = new StringBuilder("---------------------response log start---------------------");

        Response var8;
        try {
            Response clone = response.newBuilder().build();
            builder.append("\n").append("url : ").append(clone.request().url());
            builder.append("\n").append("headers : ");
            Headers headers = response.headers();
            if (headers != null && headers.size() > 0) {
                builder.append("\n").append(headers.toString());
            }

            builder.append("\n").append("code : ").append(clone.code());
            builder.append("\n").append("protocol : ").append(clone.protocol());
            if (!TextUtils.isEmpty(clone.message())) {
                builder.append("\n").append("message : ").append(clone.message());
            }

            ResponseBody body = clone.body();
            if (body == null) {
                Response var15 = response;
                return var15;
            }

            MediaType mediaType = body.contentType();
            Response var16;
            if (mediaType == null) {
                var16 = response;
                return var16;
            }

            builder.append("\n").append("contentType : ").append(mediaType.toString());
            if (!this.isText(mediaType)) {
                builder.append("\n").append("content : maybe [file part] , too large too print , ignored!");
                var16 = response;
                return var16;
            }

            String resp = body.string();
            builder.append("\n").append("content : ").append(resp);
            body = ResponseBody.create(mediaType, resp);
            var8 = response.newBuilder().body(body).build();
        } catch (Exception var12) {
            builder.append("\n").append("error : ").append(var12.toString());
            Response var4 = response;
            return var4;
        } finally {
            builder.append("\n").append("---------------------response log end-----------------------");
            LogUtils.d(new Object[]{builder.toString()});
        }

        return var8;
    }

    private boolean isText(MediaType mediaType) {
        if (mediaType.type() != null && mediaType.type().equals("text")) {
            return true;
        } else {
            return mediaType.subtype() != null && (mediaType.toString().equals("application/x-www-form-urlencoded") || mediaType.subtype().equals("json") || mediaType.subtype().equals("xml") || mediaType.subtype().equals("html") || mediaType.subtype().equals("webviewhtml"));
        }
    }

    private String bodyToString(Request request) {
        try {
            Request copy = request.newBuilder().build();
            Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (IOException var4) {
            return "something error when show requestBody.";
        }
    }
}
