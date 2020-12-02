package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleRowMapper implements RowMapper<Vehicle> {

    @Override
    public Vehicle mapRow (ResultSet resultSet, int i) throws SQLException {
                return new Vehicle()
                .setClientId(BigInteger.valueOf(resultSet.getInt("client_id")))
                .setVehId(BigInteger.valueOf(resultSet.getInt("id")))
                .setRegNo(resultSet.getString("reg_no"))
                .setOdo(BigInteger.valueOf (resultSet.getInt("odo")))
                .setType(resultSet.getString("type"))
                .setManufactorer(resultSet.getString("manufacturer"))
                .setModel(resultSet.getString("model"))
                .setYear(resultSet.getString("year"))
                .setFuel(resultSet.getString("fuel"))
                .setkW(BigInteger.valueOf (resultSet.getInt("kw")))
                .setActive(resultSet.getBoolean("active"));
    }
}
