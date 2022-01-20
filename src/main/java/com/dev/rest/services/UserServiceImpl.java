package com.dev.rest.services;

import java.util.List;

import com.dev.rest.dao.UserDao;
import com.dev.rest.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User createUser(User user) {
        userDao.save(user);
        return null;
    }

    @Override
    public User deleteUser(User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getUser(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    public User updateUser(User user) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
