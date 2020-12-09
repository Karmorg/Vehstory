package com.example.demo.repository;

import com.example.demo.ServiceLog;
import com.example.demo.ServiceLogRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ServiceLogRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void addServiceLog (ServiceLog serviceLog){
        String sql = "INSERT INTO service_history (log_date, vehicle_id, service_id, service_date, c_odo, comment, active)" +
                "VALUES (:logDate, :vehicle, :serviceID, :serviceDate, :odo, :comment, :active)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("logDate", serviceLog.getLogDate());
        paramMap.put("vehicle", serviceLog.getVehicleId());
        paramMap.put("serviceID", serviceLog.getServiceId());
        paramMap.put("serviceDate", serviceLog.getServiceDate());
        paramMap.put("odo", serviceLog.getServiceOdo());
        paramMap.put("comment", serviceLog.getComment());
        paramMap.put("active", serviceLog.getActive());

        jdbcTemplate.update(sql, paramMap);
    }

    public List<ServiceLog> getVehicleServiceLog(BigInteger vehicleId){
        String sql = "SELECT sh.id, sh.log_date, sh.vehicle_id, sl.service, sh.service_date, sh.c_odo, sh.comment" +
                " FROM service_history sh JOIN service_list sl ON sl.id=sh.service_id" +
                " WHERE vehicle_id=:vehicleId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("vehicleId",vehicleId);
        return jdbcTemplate.query(sql, paramMap, new ServiceLogRowMapper());
    }

}
