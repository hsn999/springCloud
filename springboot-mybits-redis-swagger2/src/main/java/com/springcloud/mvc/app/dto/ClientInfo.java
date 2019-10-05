package com.springcloud.mvc.app.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClientInfo implements Serializable {

    private String accessToken;

    private String userId;

    private Long mostSignBits;

    private Long leastSignBits;

}
