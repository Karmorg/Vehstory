package com.example.demo.repository;

import com.example.demo.Vehicle;
import com.example.demo.VehicleRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VehicleRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public BigInteger createVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicle (client_id, reg_no, odo, type, manufacturer," +
                "model, year, fuel, kw, active) VALUES (:client_id, :reg_no, :odo, :type, " +
                ":manufacturer, :model, :year, :fuel, :kw, :active )";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("client_id", vehicle.getClientId());
        paramMap.put("reg_no", vehicle.getRegNo());
        paramMap.put("odo", vehicle.getOdo());
        paramMap.put("type", vehicle.getType());
        paramMap.put("manufacturer", vehicle.getManufactorer());
        paramMap.put("model", vehicle.getModel());
        paramMap.put("year", vehicle.getYear());
        paramMap.put("fuel", vehicle.getFuel());
        paramMap.put("kw", vehicle.getkW());
        paramMap.put("active", vehicle.getActive());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        jdbcTemplate.update(sql, paramSource, keyHolder);
        Long vehId = (Long) keyHolder.getKeys().get("id");
        BigInteger vehicleId= BigInteger.valueOf(Math.toIntExact(vehId));
        return vehicleId;

    }

    public List<Vehicle> getMyVehicles(BigInteger clientID) {
        String sql = "SELECT client_id, reg_no, odo, type, manufacturer," +
                "model, year, fuel, kw, active FROM vehicle WHERE client_id=:clientId " +
                "AND active = :active";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("clientId", clientID);
        paramMap.put("active", true);
        return jdbcTemplate.query(sql, paramMap, new VehicleRowMapper());
    }

    public void updateVehicleStatus(BigInteger id) {
        String sql = "UPDATE vehicle SET active=:false WHERE id=:autoId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("autoId", id);
        paramMap.put("false", false);
        jdbcTemplate.update(sql, paramMap);
    }
}
