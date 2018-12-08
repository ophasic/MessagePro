package com.hwua.service.impl;

import com.hwua.dao.IUserDao;
import com.hwua.dao.impl.UserDaoDaoImpl;
import com.hwua.entity.User;
import com.hwua.service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoDaoImpl();
    }

    @Override
    public User login(User user) {
        try {
            user = userDao.query(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return user;
    }

    @Override
    public int register(User user) {
        int res = 0;
        try {
            res = userDao.save(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> uList=null;
        try {
            uList= userDao.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uList;
    }
}
