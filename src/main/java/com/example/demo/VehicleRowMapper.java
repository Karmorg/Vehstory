package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleRowMapper implements RowMapper {

    @Override
    public Object mapRow (ResultSet resultSet, int i) throws SQLException {
        Vehicle vehicle = new Vehicle(BigInteger.valueOf (resultSet.getInt("client_id")),
                resultSet.getString("reg_no"),
                BigInteger.valueOf (resultSet.getInt("odo")),
                resultSet.getString("type"),
                resultSet.getString("manufacturer"),
                resultSet.getString("model"),
                resultSet.getString("year"),
                resultSet.getString("fuel"),
                BigInteger.valueOf (resultSet.getInt("kw")),
                resultSet.getBoolean("active"));
        return vehicle;
    }
}
