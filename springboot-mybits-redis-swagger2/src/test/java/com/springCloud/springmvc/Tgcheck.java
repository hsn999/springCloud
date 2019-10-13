package com.springCloud.springmvc;

import com.springcloud.mvc.app.repository.RedisRepositoryImpl;

public class Tgcheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedisRepositoryImpl RedisRepositoryImpl = new RedisRepositoryImpl();
		
		int mobile_code = (int)((Math.random()*9+1)*100000);
		System.out.println(mobile_code);

		
		RedisRepositoryImpl.saveVerificationCode("23456789","77777");
	}
	
}
