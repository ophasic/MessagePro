package com.hwua.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

public class C3P0Utils {
	//����һ���������ӳص�(����Դ)����
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    /**
     * ��ȡ����Դ�ķ���
     * @return
     */
    public static ComboPooledDataSource getCpds() {
		return cpds;
	}

	/**
     * 
     *�����ӳ��л�ȡһ�����Ӷ���
     * @return Connection 
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = cpds.getConnection();//�����ӳ��л�ȡһ�����Ӷ���
        } catch (SQLException e) {
            throw new RuntimeException("����ʧ��");
        }
        return conn;
    }

    
}
