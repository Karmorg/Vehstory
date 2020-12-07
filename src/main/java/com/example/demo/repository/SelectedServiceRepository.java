package com.example.demo.repository;

import com.example.demo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql="UPDATE selected_service SET p_unit = :pUnit, p_value= :pValue, comment= :comment, active= :active WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", selectedService.getId());
        paramMap.put("pUnit", selectedService.getpUnit());
        paramMap.put("pValue", selectedService.getpValue());
        paramMap.put("comment",selectedService.getComment());
        paramMap.put("active", selectedService.isActive());
        jdbcTemplate.update(sql, paramMap);
    }
    public List<NameForSelectedServiceWeb> getVehicleServiceListWithServiceName (BigInteger vehicleId){
        String sql="SELECT * FROM service_list sl JOIN selected_service ss ON sl.id=ss.service_id WHERE vehicle_id= :vehicleId";
        Map<String, Object> paramMap=new HashMap<>();
        paramMap.put("vehicleId", vehicleId);
        return jdbcTemplate.query(sql, paramMap, new NameForSelectedServiceWebRowMapper());
    }
    public List<VehicleSelectedServiceDashboard> getServicesToDashboard(BigInteger vehicleId){
        String sql="SELECT ss.service_id , ss.p_unit, ss.p_value, sl.service, sh.service_date, sh.c_odo, sh.comment " +
                "FROM selected_service ss LEFT JOIN service_list sl ON ss.service_id=sl.id " +
                "LEFT JOIN (SELECT sh1.* from service_history sh1 JOIN " +
                "(SELECT vehicle_id, service_id, max(service_date) as max_date FROM service_history GROUP BY vehicle_id, service_id) sh2 " +
                "ON sh1.vehicle_id = sh2.vehicle_id and sh1.service_id = sh2.service_id and sh1.service_date = sh2.max_date) " +
                "sh ON ss.service_id = sh.service_id WHERE ss.active = true";

        Map<String, BigInteger> paramMap = new HashMap<>();
        paramMap.put("vehicleId", vehicleId);
        return  jdbcTemplate.query(sql, paramMap, new RowMapper<VehicleSelectedServiceDashboard>() {
            @Override
            public VehicleSelectedServiceDashboard mapRow(ResultSet resultSet, int i) throws SQLException {
                return new VehicleSelectedServiceDashboard()
                        .setVehicleId(vehicleId)
                        .setServiceId(BigInteger.valueOf(resultSet.getInt("service_id")))
                        .setServiceName(resultSet.getString("service"))
                        .setpUnit(resultSet.getString("p_unit"))
                        .setpValue(BigInteger.valueOf(resultSet.getInt("p_value")))
                        .setLastSDate(resultSet.getDate("service_date"))
                        .setLastSOdo(BigInteger.valueOf(resultSet.getInt("c_odo")))
                        .setComment(resultSet.getString("comment"));
            }
        });
    }
}
