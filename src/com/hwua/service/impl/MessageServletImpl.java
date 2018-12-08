package com.hwua.service.impl;

import com.hwua.dao.IMessageDao;
import com.hwua.dao.impl.MessageDaoImpl;
import com.hwua.entity.Message;
import com.hwua.entity.User;
import com.hwua.service.IMessageService;

import java.sql.SQLException;
import java.util.List;

public class MessageServletImpl implements IMessageService {
    private IMessageDao msgDao = null;
    public MessageServletImpl(){
        msgDao = new MessageDaoImpl();
    }

    /**
     * 查询登录用户收到的所有短消息
     */
    @Override
    public List<Message> queryMessageByLoginUser(int loginid, int start, int pageSize) {
        List<Message> msgList = null;
        try {
            msgList = msgDao.query(loginid, start, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return msgList;
    }

    @Override
    public Message queryMessageById(String id) {
        Message message = null;
        try {
            message = msgDao.query(id);
            message.setState(0);
            msgDao.update(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public int sendMessage(Message msg) {
        int res=0;
        try {
            res=msgDao.save(msg);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int deleteMsgById(int id) {
        int res=0;
        try {
            res=msgDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Long queryMsgCount(int loginid) {
        Long count = 0l;
        try {
            count=msgDao.queryCount(loginid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
}
