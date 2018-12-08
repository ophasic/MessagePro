package com.hwua.dao;

import com.hwua.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    public User query(User user) throws SQLException;
    public int save(User user) throws SQLException;//插入用户
    public List<User> query() throws SQLException;//查询所有的用户信息
}
