package com.hwua.dao;

import com.hwua.entity.Message;

import java.sql.SQLException;
import java.util.List;

public interface IMessageDao {
    public List<Message> query(int receiveid) throws SQLException;
    public Message query(String id) throws SQLException;
    public int update(Message msg) throws SQLException;
    public int save(Message msg) throws SQLException;
    public int delete(int id) throws  SQLException;
}
