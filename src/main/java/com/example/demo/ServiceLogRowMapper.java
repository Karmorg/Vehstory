package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceLogRowMapper implements RowMapper<ServiceLog> {

    @Override
    public ServiceLog mapRow(ResultSet resultSet, int i) throws SQLException {
        return new ServiceLog()
                .setLogDate(resultSet.getDate("log_date"))
                .setServiceId(BigInteger.valueOf(resultSet.getInt("service_id")))
                .setServiceDate(resultSet.getDate("service_date"))
                .setServiceOdo(BigInteger.valueOf(resultSet.getInt("c_odo")))
                .setComment(resultSet.getString("comment"));

    }
}
