package com.hwua.web.servlet;

import com.hwua.entity.Message;
import com.hwua.entity.User;
import com.hwua.service.impl.MessageServletImpl;
import com.hwua.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String param = req.getParameter("param");
        MessageServletImpl msgService = new MessageServletImpl();
        if(param.equals("querybyloginid")) {
            User user =(User)req.getSession(false).getAttribute("user");
            List<Message> messages = msgService.queryMessageByLoginUser(user.getId());
            //把业务层返回的数据放到作用域中,并转发给页面进行显示
            req.setAttribute("msgList", messages);
            req.getRequestDispatcher("/main.jsp").forward(req, resp);
        } else if(param.equals("showmsgbyid")) {
            String id = req.getParameter("id");
            Message msg = msgService.queryMessageById(id);
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/readMsg.jsp").forward(req, resp);
        } else if(param.equals("send")) {
            User user = (User)req.getSession(false).getAttribute("user");
            int sendid = user.getId();
            String title = req.getParameter("title");
            String msgcontent = req.getParameter("content");
            int receiveid=Integer.parseInt(req.getParameter("toUser"));
            int state=1;
            String msg_create_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            Message msg = new Message(sendid, title, msgcontent, state, receiveid, msg_create_date);
            int res = msgService.sendMessage(msg);
            if(res>0){
                resp.sendRedirect(req.getContextPath()+"/user.do?param=queryallusers");
            }
        }else if(param.equals("delete")){
            String id = req.getParameter("id");
            int res=msgService.deleteMsgById(Integer.parseInt(id));
            if(res>0){
                resp.sendRedirect(req.getContextPath() + "/msg.do?param=querybyloginid");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

