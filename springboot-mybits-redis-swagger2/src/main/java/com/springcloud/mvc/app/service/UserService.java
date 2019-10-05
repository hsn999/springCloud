package com.springcloud.mvc.app.service;

import javax.validation.Valid;

import com.springcloud.mvc.app.dto.TokenInfo;
import com.springcloud.mvc.app.entity.User;
import com.springcloud.mvc.app.form.UserLoginForm;

public interface UserService {
    public User getUserById(int userId);

    boolean addUser(User record);
    
    boolean updateUser(User user);


    TokenInfo auth(@Valid UserLoginForm userLoginForm);

}
