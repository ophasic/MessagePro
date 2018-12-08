package com.hwua.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

public class C3P0Utils {
	//创建一个管理连接池的(数据源)对象
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    /**
     * 获取数据源的方法
     * @return
     */
    public static ComboPooledDataSource getCpds() {
		return cpds;
	}

	/**
     * 
     *从连接池中获取一个连接对象
     * @return Connection 
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = cpds.getConnection();//从连接池中获取一个连接对象
        } catch (SQLException e) {
            throw new RuntimeException("连接失败");
        }
        return conn;
    }

    
}
