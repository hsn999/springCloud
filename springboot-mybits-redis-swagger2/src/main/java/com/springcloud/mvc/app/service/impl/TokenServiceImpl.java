package com.springcloud.mvc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.springcloud.mvc.app.dto.TokenInfo;
import com.springcloud.mvc.app.repository.IRedisRepository;
import com.springcloud.mvc.app.service.ITokenService;

@Service
public class TokenServiceImpl implements ITokenService {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    private IRedisRepository redisRepository;

    @Override
    public TokenInfo getTokenInfo(String accessToken) {
        TokenInfo tokenInfo = redisRepository.findTokenInfoByAccessToken(accessToken);
        return tokenInfo;
    }

}
