package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OneServiceRowMapper implements RowMapper {

    @Override
    public Object mapRow (ResultSet resultSet, int i) throws SQLException {
        OneService oneService = new OneService(BigInteger.valueOf(resultSet.getInt("id")),
                resultSet.getString("service"),
                resultSet.getBoolean("active"));
        return oneService;
    }

}
