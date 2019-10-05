package com.springcloud.mvc.app.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.springcloud.mvc.app.dto.TokenInfo;
import com.springcloud.mvc.app.dto.UserInfoDTO;
import com.springcloud.mvc.app.entity.User;
import com.springcloud.mvc.app.form.UserLoginForm;
import com.springcloud.mvc.app.service.UserService;
import com.springcloud.mvc.app.wrapper.ResultWrapper;
import com.springcloud.mvc.core.support.web.controller.BaseController;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(value = "UserController", tags = {"用户API"})
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController<UserInfoDTO> {

    @Resource
    private UserService userService;


    @ApiOperation("用户登录")
    @PostMapping("/login")
    public ResultWrapper<TokenInfo> login(
            @Valid @RequestBody UserLoginForm userLoginForm,
            BindingResult bindingResult){
        /**
         * 参数验证
         */
        validateParams(bindingResult);
        /**
         * 登录
         */
        TokenInfo tokenInfo = userService.auth(userLoginForm);
        /**
         * 返回token
         */
        return ResultWrapper.successWithData(tokenInfo);

    }

    @ApiOperation("获取用户信息")
    @GetMapping("/showUser")
    @ResponseBody
    public User showUser(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return user;
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/updateUser")
    @ResponseBody
    public ResultWrapper<Map<String, Object>> updateUser(User user){
        
    	boolean value = this.userService.updateUser(user);
        ResultWrapper<Map<String, Object>> re= new ResultWrapper<Map<String, Object>>();
        ResultWrapper.successWithData("result", value);
        return re;
    }


}
