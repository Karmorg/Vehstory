package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OneServiceRowMapper implements RowMapper<OneService> {

    @Override
    public OneService mapRow (ResultSet resultSet, int i) throws SQLException {
        return new OneService(BigInteger.valueOf(resultSet.getInt("id")),
                resultSet.getString("service"),
                resultSet.getBoolean("active"));
    }

}
