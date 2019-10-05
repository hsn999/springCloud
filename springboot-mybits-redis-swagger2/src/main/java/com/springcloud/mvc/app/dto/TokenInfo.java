package com.springcloud.mvc.app.dto;

import lombok.Data;

@Data
public class TokenInfo {

    private String accessToken;

    private String userId;

}
