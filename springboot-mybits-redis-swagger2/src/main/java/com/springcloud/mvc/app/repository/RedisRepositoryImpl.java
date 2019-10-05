package com.springcloud.mvc.app.repository;

import static com.springcloud.mvc.app.constant.RedisKeyTemplate.*;
import static com.springcloud.mvc.app.util.RedisKeyUtil.buildKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.springcloud.mvc.app.dto.ClientInfo;
import com.springcloud.mvc.app.dto.TokenInfo;
import com.springcloud.mvc.app.util.RedisUtil;


@Component
public class RedisRepositoryImpl implements IRedisRepository {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void saveVerificationCode(String phoneNumber, String verificationInfo) {
        RedisUtil.set(redisTemplate, buildKey(T_VERIFICATION_CODE, phoneNumber), verificationInfo);
    }


    @Override
    public void saveAccessToken(TokenInfo tokenInfo) {
        RedisUtil.set(redisTemplate, buildKey(T_ACCESS_TOKEN, tokenInfo.getAccessToken()), tokenInfo);
    }

    @Override
    public void saveUserAccessToken(String userId, String accessToken) {
        RedisUtil.set(redisTemplate, buildKey(T_USER_CURRENT_TOKEN, userId), accessToken);
    }

    @Override
    public String findAccessTokenByUserId(String userId) {
        return RedisUtil.<String>get(redisTemplate, buildKey(T_USER_CURRENT_TOKEN, userId), String.class);
    }

    @Override
    public String findVerificationCodeByMoble(String phoneNumber) {
        return RedisUtil.<String>get(redisTemplate, buildKey(T_VERIFICATION_CODE, phoneNumber), String.class);
    }

    @Override
    public TokenInfo findTokenInfoByAccessToken(String accessToken) {
        return RedisUtil.<TokenInfo>get(redisTemplate, buildKey(T_ACCESS_TOKEN, accessToken), TokenInfo.class);
    }

    @Override
    public void deleteAccessToken(String accessTToken) {
        RedisUtil.del(redisTemplate, buildKey(T_ACCESS_TOKEN, accessTToken));
    }

    @Override
    public void deleteUserAccessToken(String userId) {
        RedisUtil.del(redisTemplate, buildKey(T_USER_CURRENT_TOKEN, userId));
    }

    @Override
    public void deleteVerificationCode(String phoneNumber) {
        RedisUtil.del(redisTemplate, buildKey(T_VERIFICATION_CODE, phoneNumber));
    }

    @Override
    public void saveClientInfo(String userId, ClientInfo clientInfo) {
        RedisUtil.set(redisTemplate, buildKey(T_USER_CURRENT_CLIENT, userId), clientInfo);
    }

    @Override
    public void deleteClientInfo(String userId) {
        RedisUtil.del(redisTemplate, buildKey(T_USER_CURRENT_CLIENT, userId));
    }

    @Override
    public ClientInfo findClientInfoByUserId(String userId) {
        return RedisUtil.get(redisTemplate, buildKey(T_USER_CURRENT_CLIENT, userId), ClientInfo.class);
    }

    @Override
    public void deleteOfflineMessage(String userId) {
        RedisUtil.del(redisTemplate, buildKey(T_OFFLINE_MSG, userId));
    }
}
