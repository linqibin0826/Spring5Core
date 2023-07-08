package com.linqibin.Chapter2.dao;


import com.linqibin.Chapter2.domain.Student;
import com.linqibin.Chapter2.utils.JdbcTemplate03;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 目前只能处理student这一张表，还需要进一步优化
 *
 * @author lqb
 * @date 2023/6/24
 */
public class JdbcDemo03 {

    public Integer save(Student student) {
        return JdbcTemplate03.update("INSERT INTO student(NAME) VALUES(?)", student.getName());
    }

    public Integer delete(Long id) {
        return JdbcTemplate03.update("DELETE FROM student WHERE ID = ?", id);
    }

    public Integer update(Student student) {
        return JdbcTemplate03.update("UPDATE student SET name = ?", student.getName());
    }

    public Student getOne(Long id) {
        List<Student> list = JdbcTemplate03.query("SELECT * FROM student WHERE ID = ?", id);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    public List<Student> list() {
        return JdbcTemplate03.query("SELECT * FROM student");
    }


}
