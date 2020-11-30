package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectedServiceRowMapper implements RowMapper {

    @Override
    public Object mapRow (ResultSet resultSet, int i) throws SQLException{
        SelectedService selectedService = new SelectedService(
                BigInteger.valueOf (resultSet.getInt("id")),
                BigInteger.valueOf(resultSet.getInt("vehicle_id")),
                BigInteger.valueOf(resultSet.getInt("service_id")),
                resultSet.getString("p_unit"),
                BigInteger.valueOf(resultSet.getInt("p_value")),
                resultSet.getString("comment"),
                resultSet.getBoolean("active"));
        return selectedService;
    }

}
