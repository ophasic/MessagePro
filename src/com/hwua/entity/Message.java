package com.hwua.entity;

public class Message {
    private int id;
    private int sendid;
    private String title;
    private int state;
    private int receiveid;
    private String msgcontent;
    private String msg_create_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSendid() {
        return sendid;
    }

    public void setSendid(int sendid) {
        this.sendid = sendid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getReceiveid() {
        return receiveid;
    }

    public void setReceiveid(int receiveid) {
        this.receiveid = receiveid;
    }

    public String getMsgcontent() {
        return msgcontent;
    }

    public void setMsgcontent(String msgcontent) {
        this.msgcontent = msgcontent;
    }

    public String getMsg_create_date() {
        return msg_create_date;
    }

    public void setMsg_create_date(String msg_create_date) {
        this.msg_create_date = msg_create_date;
    }

    public Message(int sendid, String title, String msgcontent, int state, int receiveid, String msg_create_date) {
        super();
        this.sendid = sendid;
        this.title = title;
        this.msgcontent = msgcontent;
        this.state = state;
        this.receiveid = receiveid;
        this.msg_create_date = msg_create_date;
    }

    public Message(int id, int sendid, String title, int state, int receiveid, String msgcontent, String msg_create_date) {
        this.id = id;
        this.sendid = sendid;
        this.title = title;
        this.state = state;
        this.receiveid = receiveid;
        this.msgcontent = msgcontent;
        this.msg_create_date = msg_create_date;
    }

    public Message() {
    }
}
