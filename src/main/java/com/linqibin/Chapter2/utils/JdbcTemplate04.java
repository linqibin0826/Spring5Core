package com.linqibin.Chapter2.utils;

import com.linqibin.Chapter2.dao.IRowMapper;
import com.linqibin.Chapter2.domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * 进一步优化，将处理结果集的代码放到Mapper中
 *
 * @Author linqibin
 * @Date 2023/6/25 22:37
 * @Email 1214219989@qq.com
 */
public class JdbcTemplate04 {

    public static List<Student> query(String sql, IRowMapper rowMapper, Object... params) {
        List<Student> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0, paramsLength = params.length; i < paramsLength; i++) {
                Object param = params[i];
                ps.setObject(i + 1, param);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                Student student = new Student(id, name);
                list.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return list;
    }

    public static Integer update(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer result = 0;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, ps, conn);
        }
        return result;
    }
}

