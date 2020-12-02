package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NameForSelectedServiceWebRowMapper implements RowMapper<NameForSelectedServiceWeb> {

    @Override
    public NameForSelectedServiceWeb mapRow (ResultSet resultSet, int i) throws SQLException{
        return new NameForSelectedServiceWeb()
                .setId(BigInteger.valueOf(resultSet.getInt("id")))
                .setVehicleId(BigInteger.valueOf(resultSet.getInt("vehicle_id")))
                .setServiceName(resultSet.getString("service"))
                .setpUnit(resultSet.getString("p_unit"))
                .setpValue(BigInteger.valueOf(resultSet.getInt("p_value")))
                .setComment(resultSet.getString("comment"))
                .setActive(resultSet.getBoolean("active"));
    }
}
