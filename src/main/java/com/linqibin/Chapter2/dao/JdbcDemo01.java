package com.linqibin.Chapter2.dao;


import com.linqibin.Chapter2.domain.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Spring5核心原理， P24
 * 弊端：重复的代码太多了，每执行一条sql就要连接一次。
 *
 * @author lqb
 * @date 2023/2/27
 */
public class JdbcDemo01 {

    public void save(Student student) throws Exception {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "123456");

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://123.60.92.39:3306/spring5core" +
                    "?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", properties);

            statement = connection.prepareStatement("insert into `student`(id, name) values (?, ?)");
            statement.setLong(1, 1);
            statement.setString(2, "林琪斌");

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void delete(Long id) {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "123456");

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://123.60.92.39:3306/spring5core" +
                    "?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", properties);

            statement = connection.prepareStatement("DELETE FROM student WHERE ID = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void update(Student student) {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "123456");

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://123.60.92.39:3306/spring5core" +
                    "?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", properties);

            statement = connection.prepareStatement("UPDATE student SET name = ?");
            statement.setString(1, student.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
