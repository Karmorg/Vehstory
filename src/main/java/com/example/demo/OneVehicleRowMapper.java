package com.example.demo;


import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OneVehicleRowMapper implements RowMapper<OneVehicle> {
    @Override
    public OneVehicle mapRow(ResultSet resultSet, int i) throws SQLException{
        return new OneVehicle()
                .setId(BigInteger.valueOf(resultSet.getInt("id")))
                .setManufacturer(resultSet.getString("manufacturer"))
                .setModel(resultSet.getString("model"))
                .setRegNo(resultSet.getString("reg_no"));
    }


}
