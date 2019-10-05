package com.springcloud.mvc.app.exception;


import com.springcloud.mvc.app.enums.ErrorCodeEnum;

public class UserException extends BaseException {

    public UserException(int code, String message) {
        super(code, message);
    }

    public UserException(ErrorCodeEnum codeEnum, Object... args) {
        super(codeEnum, args);
    }
}
