//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.averysk.mvip.exception;

/**
 * Created by Averysk
 */
public class NoNetworkException extends BusinessException {
    private static final long serialVersionUID = -4676995504441418874L;
    public String message;

    public NoNetworkException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
