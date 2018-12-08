package com.hwua.web.servlet;

import com.alibaba.fastjson.JSON;
import com.hwua.entity.Message;
import com.hwua.entity.PageEntity;
import com.hwua.entity.User;
import com.hwua.service.impl.MessageServletImpl;
import com.hwua.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

            PageEntity pageEntity = new PageEntity();
            int pageNo = Integer.parseInt(req.getParameter("pageNo"));
            int pageSize = Integer.parseInt(req.getParameter("pageSize"));
            Long totalRecords = msgService.queryMsgCount(user.getId());
            pageEntity.setPageNo(pageNo);
            pageEntity.setPageSize(pageSize);
            pageEntity.setTotalRecords(totalRecords);

            List<Message> messages = msgService.queryMessageByLoginUser(user.getId(), (pageNo - 1) * pageSize, pageSize);
            pageEntity.setMsgList(messages);
            resp.setContentType("application/json;charset=utf-8");
            String json = JSON.toJSONString(pageEntity, true);
            resp.getWriter().write(json);
        } else if(param.equals("showmsgbyid")) {
            String id = req.getParameter("id");
            Message msg = msgService.queryMessageById(id);
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/view/readMsg.jsp").forward(req, resp);
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
            resp.setContentType("text/html;charset=uft-8");
            PrintWriter out = resp.getWriter();
            if(res>0){
                out.write("success");
            } else {
                out.write("failture");
            }
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

