package com.hwua.service;

import com.hwua.entity.User;

import java.util.List;

public interface IUserService {
    public User login(User user);
    public int register(User user);//注册
    public List<User> getAllUsers();
}
