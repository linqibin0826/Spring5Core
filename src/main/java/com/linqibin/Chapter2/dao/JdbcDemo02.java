package com.linqibin.Chapter2.dao;


import com.linqibin.Chapter2.domain.Student;
import com.linqibin.Chapter2.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Spring5核心原理， P27
 * 将重复的代码抽取，放到JDBCUtil里面。
 *
 * @author lqb
 * @date 2023/6/24
 */
public class JdbcDemo02 {

    public Integer save(Student student) {


        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement("insert into `student`(name) values (?)");
            statement.setString(1, student.getName());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, statement, connection);
        }

        return result;
    }

    public void delete(Long id) {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement("DELETE FROM student WHERE ID = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, statement, connection);
        }

    }

    public boolean update(Student student) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();

            statement = connection.prepareStatement("UPDATE student SET name = ?");
            statement.setString(1, student.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.close(null, statement, connection);
        }
        return true;
    }


}
