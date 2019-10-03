package com.springCloud.jpa.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springCloud.jpa.bean.User;
import com.springCloud.jpa.dao.UserJpaDao;
import com.springCloud.jpa.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserJpaDao userJpaDao;
	/**
	 * 
	 * @param username
	 * @return
	 */
	@Override
	public User getUserByName(String username) {
		return userJpaDao.findByName(username);
	}
}
