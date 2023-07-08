package com.linqibin.Chapter2.dao;

import com.linqibin.Chapter2.domain.Student;
import org.junit.Test;

/**
 * @Author linqibin
 * @Date 2023/6/24 15:35
 * @Email 1214219989@qq.com
 */

public class JdbcDemo03Test {
    JdbcDemo03 demo03 = new JdbcDemo03();

    @Test
    public void testSave() {
        Student linqibin = new Student();
        linqibin.setName("linqibin");
        Integer save = demo03.save(linqibin);
        if (save == 1) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }
    }

    @Test
    public void testUpdate() {
        Student student = new Student();
        student.setName("youmei");
        student.setId(1L);
        System.out.println(demo03.update(student));

    }

    @Test
    public void testGetOne() {
        System.out.println(demo03.getOne(2L));
    }

    @Test
    public void testList() {
        System.out.println(demo03.list());
    }

    @Test
    public void testDelete() {
        System.out.println(demo03.delete(1L));
    }




}

