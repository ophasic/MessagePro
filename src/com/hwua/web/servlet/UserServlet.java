package com.hwua.web.servlet;

import com.hwua.entity.User;
import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("param");
        IUserService us = new UserServiceImpl();
        if (param.equals("login")) {
            String name = req.getParameter("name");
            String pwd = req.getParameter("pwd");
            User user = new User(name, pwd);

            user = us.login(user);
            if (user != null) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/msg.do?param=querybyloginid");
            } else {
                req.getSession().setAttribute("info", "用户名或密码出错");
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            }
        }else if(param.equals("logout")){
            req.getSession(false).invalidate();//销毁session
            resp.sendRedirect(req.getContextPath()+"/index.jsp");//回到登录页面
        }else if(param.equals("queryallusers")){
            List<User> uList = us.getAllUsers();
            req.setAttribute("users", uList);
            req.getRequestDispatcher("/newMsg.jsp").forward(req, resp);
        }else if(param.equals("doRegister")){
            String name = req.getParameter("name");
            String pwd = req.getParameter("pwd");
            String email = req.getParameter("email");
            User user = new User(name, pwd, email);
            int res = us.register(user);
            if (res > 0) {
                resp.sendRedirect(req.getContextPath() + "main.jsp");
            }
        }
    }
}
