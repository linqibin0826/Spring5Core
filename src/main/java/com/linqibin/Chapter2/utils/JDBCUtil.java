package com.linqibin.Chapter2.utils;

import com.mysql.cj.protocol.Resultset;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


/**
 * @Author linqibin
 * @Date 2023/6/24 15:04
 * @Email 1214219989@qq.com
 */
public class JDBCUtil {

    private static String driverClassName;
    private static String url;
    private static String username;
    private static String password;

    static {
        InputStream stream = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        // 1.加载配置文件
        Properties properties;
        try {
            properties = new Properties();
            properties.load(stream);
            // 2.加载驱动
            driverClassName = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            username = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");
            Class.forName(driverClassName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接对象
     *
     * @return
     */
    public static Connection getConnection() {

        try {
            // 3.获取连接
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rs, Statement s, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

