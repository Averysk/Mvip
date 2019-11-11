//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.averysk.mvip.exception;

/**
 * Created by Averysk
 */
public class HttpException extends BusinessException {
    private static final long serialVersionUID = 237667728586504197L;
    public String message;

    public HttpException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
