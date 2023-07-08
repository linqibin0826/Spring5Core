package com.linqibin.Chapter2.dao;

import com.linqibin.Chapter2.domain.Student;
import org.junit.Test;

/**
 * @Author linqibin
 * @Date 2023/6/24 15:35
 * @Email 1214219989@qq.com
 */

public class JdbcDemo02Test {
    JdbcDemo02 demo02 = new JdbcDemo02();

    @Test
    public void testSave() {
        Student linqibin = new Student();
        linqibin.setName("linqibin"); 
        Integer save = demo02.save(linqibin);
        if (save == 1) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }
    }

    @Test
    public void testUpdate() {
        Student student = new Student();
        student.setName("zhangsan");
        student.setId(2L);
        boolean update = demo02.update(student);
        assert update;
    }

    @Test
    public void testDelete() {
        demo02.delete(1L);
    }


}

