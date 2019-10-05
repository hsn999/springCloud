package com.springcloud.mvc.app.service;

import com.springcloud.mvc.app.dto.TokenInfo;

public interface ITokenService {

    /**
     * 从Redis获取token的信息
     * @param accessToken
     * @return
     */
    TokenInfo getTokenInfo(String accessToken);

}
