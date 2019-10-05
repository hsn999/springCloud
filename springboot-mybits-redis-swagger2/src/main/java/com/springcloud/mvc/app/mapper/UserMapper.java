package com.springcloud.mvc.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.springcloud.mvc.app.entity.User;
import com.springcloud.mvc.app.form.UserLoginForm;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User queryUser(UserLoginForm userLoginForm);


}
