package com.hwua.dao.impl;

import com.hwua.dao.IUserDao;
import com.hwua.entity.User;
import com.hwua.util.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoDaoImpl implements IUserDao {
    @Override
    public User query(User user) throws SQLException {
        String sql = "select id, name, pwd, email from users where name = ? and pwd = ?";
        Object[] params = {user.getName(), user.getPwd()};
        QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
        user = qr.query(sql, new BeanHandler<>(User.class), params);
        return user;
    }

    @Override
    public int save(User user) throws SQLException {
        String sql = "insert into users values(null, ?, ?, ?)";
        Object[] params = {user.getName(), user.getPwd(), user.getEmail()};
        QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
        return qr.update(sql, params);
    }

    @Override
    public List<User> query() throws SQLException {
        String sql = "select id,name,pwd,email from users";
        Object[] params = null;
        QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
        return qr.query(sql, new BeanListHandler<>(User.class), params);
    }
}
