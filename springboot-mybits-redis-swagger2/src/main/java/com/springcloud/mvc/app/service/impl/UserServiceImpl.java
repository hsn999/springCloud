package com.springcloud.mvc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.mvc.app.dto.TokenInfo;
import com.springcloud.mvc.app.entity.User;
import com.springcloud.mvc.app.enums.ErrorCodeEnum;
import com.springcloud.mvc.app.exception.UserException;
import com.springcloud.mvc.app.form.UserLoginForm;
import com.springcloud.mvc.app.mapper.UserMapper;
import com.springcloud.mvc.app.repository.IRedisRepository;
import com.springcloud.mvc.app.service.UserService;
import com.springcloud.mvc.common.util.TokenUtil;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private IRedisRepository redisRepository;


    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public boolean addUser(User record){
        boolean result = false;
        try {
            userMapper.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public TokenInfo auth(UserLoginForm userLoginForm) {
        /**
         * 查找用户
         */
        User user = userMapper.queryUser(userLoginForm);
        if (user==null){
            throw new UserException(ErrorCodeEnum.PASSWORD_ERROR);
        }
                /*
          3.生成accessToken
         */
        String accessToken = TokenUtil.genToken();

        /*
          4.将accessToken和用户信息存储到Redis,并删除旧的accessToken
         */
        String userId = user.getId();

        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setUserId(user.getId());
        tokenInfo.setAccessToken(accessToken);

    // 保存新token,更新用户当前使用的token
        redisRepository.saveAccessToken(tokenInfo);
        redisRepository.saveUserAccessToken(userId, accessToken);

        /*
          5.返回登录结果
         */
        return tokenInfo;

    }

	@Override
	public boolean updateUser(User record) {
		// TODO Auto-generated method stub
		return true;
	}



}
