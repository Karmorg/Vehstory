package com.example.demo.repository;

import com.example.demo.SelectedServiceRowMapper;
import com.example.demo.SelectedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SelectedServiceRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;


    public void insertSelectedService (SelectedService selectedService){
        String sql = "INSERT INTO selected_service (vehicle_id, service_id, p_unit, p_value, comment, active) " +
                "VALUES (:vehicleId, :serviceId, :pUnit, :pValue, :comment, :active)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("vehicleId", selectedService.getVehicleId());
        paramMap.put("serviceId", selectedService.getServiceId());
        paramMap.put("pUnit", selectedService.getpUnit());
        paramMap.put("pValue", selectedService.getpValue());
        paramMap.put("comment", selectedService.getComment());
        paramMap.put("active", selectedService.isActive());
        jdbcTemplate.update(sql, paramMap);
    }

    public List<SelectedService> getSelectedService (BigInteger vehicleId){
        String sql= "SELECT id, vehicle_id, service_id, p_unit, p_value, comment, active " +
                "FROM selected_service WHERE vehicle_id = :vehicleID AND active = :active2";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("vehicleID", vehicleId);
        paramMap.put("active2", true);
        return  jdbcTemplate.query(sql,paramMap, new SelectedServiceRowMapper());
    }
    public List<SelectedService> getVehicleServiceList (BigInteger vehicleId){
        String sql= "SELECT id, vehicle_id, service_id, p_unit, p_value, comment, active " +
                "FROM selected_service WHERE vehicle_id = :vehicleID2";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("vehicleID2", vehicleId);
        return  jdbcTemplate.query(sql,paramMap, new SelectedServiceRowMapper());
    }
    public void updateSelectedService (SelectedService selectedService){
        String sql="UPDATE selected_service SET p_unit, p_value, comment, active WHERE vehicle_id = :vehicleID3 AND active = :active3";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("vehicleID3", selectedService.getVehicleId());
        paramMap.put("active3", true);
        jdbcTemplate.update(sql, paramMap);
    }
}
