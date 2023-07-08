package com.linqibin.Chapter2.dao;

import java.sql.ResultSet;

public interface IRowMapper<T> {

    T rsh(ResultSet rs);
}
