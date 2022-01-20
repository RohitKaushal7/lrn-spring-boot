package com.dev.rest.services;

import java.util.List;

import com.dev.rest.models.User;

public interface UserService {
    public List<User> getUsers();
    public User getUser(long id);
    public User updateUser(User user);
    public User createUser(User user);
    public User deleteUser(User user);
}
