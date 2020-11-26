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
        paramMap.put("comment", selectedService.getComment());
        paramMap.put("active", selectedService.isActive());
        jdbcTemplate.update(sql, paramMap);
    }


    public List<SelectedService> getSelectedService (BigInteger vehicleId){
        String sql= "SELECT vehicle_id, service_id, p_unit, p_value, comment, active " +
                "FROM selected_service WHERE vehicle_id = :vehicleID AND active = :active";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("vehicleID", vehicleId);
        paramMap.put("active", true);
        List<SelectedService> selectedServicesList =  jdbcTemplate.query(sql,paramMap, new SelectedServiceRowMapper());
        return  selectedServicesList;
    }
}
