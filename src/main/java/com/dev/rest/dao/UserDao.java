package com.dev.rest.dao;

import com.dev.rest.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    
}
