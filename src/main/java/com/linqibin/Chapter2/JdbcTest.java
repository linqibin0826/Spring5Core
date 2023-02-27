package com.linqibin.Chapter2;


import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * Spring5核心原理， P24
 * @author lqb
 * @date 2023/2/27
 */
public class JdbcTest {

    public void save(Student student) throws Exception {
        // 1. 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "123456");

        Connection connection = DriverManager.getConnection("jdbc:mysql://123.60.92.39:3306/spring5core" +
                "?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", properties);

        PreparedStatement statement = connection.prepareStatement("insert into `student`(id, name) values (?, ?)");
        statement.setLong(1, 1);
        statement.setString(2, "林琪斌");

        statement.executeUpdate();

        statement.close();
        connection.close();


    }
}
