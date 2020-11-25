package com.example.demo.repository;

import com.example.demo.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class VehicleRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void createVehicle (Vehicle vehicle){
        String sql = "INSERT INTO vehicle (client_id, reg_no, odo, type, manufacturer," +
                "model, year, fuel, kw, active) VALUES (:client_no, :reg_no, :odo," +
                ":manufacturer, :model, :year, :fuel, :kw, :active )";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("client_id", vehicle.getClient_id());
        paramMap.put("reg_no", vehicle.getRegNo());
        paramMap.put("odo", vehicle.getOdo());
        paramMap.put("manufacturer", vehicle.getManufactorer());
        paramMap.put("model", vehicle.getModel());
        paramMap.put("year", vehicle.getYear());
        paramMap.put("fuel", vehicle.getFuel());
        paramMap.put("kw", vehicle.getkW());
        paramMap.put("active", vehicle.getActive());
        jdbcTemplate.update(sql, paramMap);
    }
}
