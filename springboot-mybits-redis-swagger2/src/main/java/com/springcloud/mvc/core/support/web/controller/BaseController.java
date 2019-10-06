package com.springcloud.mvc.core.support.web.controller;

import org.springframework.validation.BindingResult;

import com.springcloud.mvc.common.constant.SysConstant;
import com.springcloud.mvc.common.enums.BaseErrorCodeEnum;
import com.springcloud.mvc.common.util.ThreadLocalMap;
import com.springcloud.mvc.core.exception.SysException;

/**
 * @author 通用Controller
 * @param <T> 当前登录用户的Java类型
 */
public class BaseController<T> {

    protected T getCurrentUserInfo() {
        T currentUser = (T) ThreadLocalMap.get(SysConstant.THREAD_LOCAL_KEY_LOGIN_USER);

        if (null == currentUser) {
            throw new SysException(BaseErrorCodeEnum.NO_USER_INFO_FOUND);
        }

        return currentUser;
    }

    protected void validateParams(BindingResult bindingResult) {
    	System.out.println("bindingResult:"+bindingResult.getTarget()+"--"+bindingResult.getAllErrors());
        if (bindingResult.hasErrors()) {
            throw new SysException(BaseErrorCodeEnum.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
    }

}
