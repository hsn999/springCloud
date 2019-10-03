package com.springCloud.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springCloud.jpa.bean.User;

/**
 * The Interface UserJpaDao.
 * @author abel
 */
public interface UserJpaDao extends JpaRepository<User, Long> {

    /**
     * Find by name.
     *
     * @param name the name
     * @return the user
     */
    User findByName(String name);


}