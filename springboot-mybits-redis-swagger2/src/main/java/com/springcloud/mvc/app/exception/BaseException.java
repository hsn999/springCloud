package com.springcloud.mvc.app.exception;


import com.springcloud.mvc.app.enums.ErrorCodeEnum;
import com.springcloud.mvc.common.enums.BaseErrorCodeEnum;
import com.springcloud.mvc.core.exception.SysException;

public class BaseException extends SysException {


    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(BaseErrorCodeEnum codeEnum, Object... args) {
        super(codeEnum, args);
    }

    public BaseException(ErrorCodeEnum codeEnum, Object... args) {
        super(String.format(codeEnum.getMessage(), args));
        this.code = codeEnum.getCode();
    }

}
