package com.hwua.dao.impl;

import com.hwua.dao.IMessageDao;
import com.hwua.entity.Message;
import com.hwua.util.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class MessageDaoImpl implements IMessageDao {
    @Override
    public List<Message> query(int receiveid, int start, int pageSize) throws SQLException {
        String sql = "select id,sendid,title,msgcontent,state,receiveid,msg_create_date from messages where receiveid=? order by msg_create_date desc limit ?, ?";
        Object[] params = { receiveid, start, pageSize };
        QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
        return qr.query(sql, new BeanListHandler<>(Message.class), params);
    }

    @Override
    public Message query(String id) throws SQLException {
        String sql = "select id,sendid,title,msgcontent,state,receiveid,msg_create_date from messages where id = ?";
        Object[] params = {id};
        QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
        return qr.query(sql, new BeanHandler<>(Message.class), params);
    }

    @Override
    public int update(Message msg) throws SQLException {
        String sql = "update messages set state = ? where id = ?";
        Object[] params = {msg.getState(), msg.getId()};
        QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
        return qr.update(sql, params);
    }

    @Override
    public int save(Message msg) throws SQLException {
        String sql="insert into messages values(null,?,?,?,?,?,?)";
        Object [] params={msg.getSendid(),msg.getTitle(),msg.getMsgcontent(),msg.getState(),msg.getReceiveid(),msg.getMsg_create_date()};
        QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
        return qr.update(sql, params);
    }

    @Override
    public int delete(int id) throws SQLException {
        String sql = "delete from messages where id=?";
        Object [] params={id};
        QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
        return qr.update(sql, params);
    }

    @Override
    public Long queryCount(int receiveid) throws SQLException {
        String sql = "select count(*) from messages where receiveid = ?";
        Object [] params = {receiveid};
        QueryRunner qr = new QueryRunner(C3P0Utils.getCpds());
        return (Long) qr.query(sql, new ScalarHandler(), params);
    }
}
