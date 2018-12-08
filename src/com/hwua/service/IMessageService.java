package com.hwua.service;

import com.hwua.entity.Message;
import com.hwua.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IMessageService {
    public List<Message> queryMessageByLoginUser(int loginid, int start, int pageSize);
    public Message queryMessageById(String id);
    public int sendMessage(Message msg);
    public int deleteMsgById(int id);
    public Long queryMsgCount(int loginid);
}
