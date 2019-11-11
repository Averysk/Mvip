//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.averysk.mvip.exception;

/**
 * Created by Averysk
 */
public class LogonFailureException extends BusinessException {
    private static final long serialVersionUID = 6401217098607368750L;
    public String message;

    public LogonFailureException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
