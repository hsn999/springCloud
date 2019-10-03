package com.springCloud.jpa.service;

import java.util.Map;

import com.springCloud.jpa.bean.User;

/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Gets the user by name.
	 *
	 * @param username the user name
	 * @return the user by name
	 */
	public User getUserByName(String username);
	
	
}
