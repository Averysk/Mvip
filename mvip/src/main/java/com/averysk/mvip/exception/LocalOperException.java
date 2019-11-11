//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.averysk.mvip.exception;

/**
 * Created by Averysk
 */
public class LocalOperException extends BusinessException {
    private static final long serialVersionUID = 6401217098607368751L;
    public int code;
    public String message;

    public LocalOperException(int code, String message) { this.code = code; this.message = message; }

    public int getCode() { return code; }

    @Override
    public String getMessage() {
        return this.message;
    }
}
