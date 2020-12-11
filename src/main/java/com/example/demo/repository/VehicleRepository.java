package com.example.demo.repository;

import com.example.demo.*;
import com.example.demo.exception.ApplicationException;
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

    public BigInteger createVehicle(Vehicle newVehicle) {
        String sql = "INSERT INTO vehicle (client_id, reg_no, odo, type, manufacturer," +
                "model, year, fuel, kw, active) VALUES (:client_id, :reg_no, :odo, :type, " +
                ":manufacturer, :model, :year, :fuel, :kw, :active )";
        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("client_id", newVehicle.getClientId());
        paramMap.put("reg_no", newVehicle.getRegNo());
        paramMap.put("odo", newVehicle.getOdo());
        paramMap.put("type", newVehicle.getType());
        paramMap.put("manufacturer", newVehicle.getManufactorer());
        paramMap.put("model", newVehicle.getModel());
        paramMap.put("year", newVehicle.getYear());
        paramMap.put("fuel", newVehicle.getFuel());
        paramMap.put("kw", newVehicle.getkW());
        paramMap.put("active", newVehicle.getActive());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        jdbcTemplate.update(sql, paramSource, keyHolder);

        Map<String, Object> keyMap = keyHolder.getKeys();
        if (keyMap == null) {
            throw new ApplicationException("viga");
        }
        Long vehId = (Long) keyMap.get("id");
        return BigInteger.valueOf(Math.toIntExact(vehId));
    }

    public List<Vehicle> getMyVehicles(BigInteger clientID) {
        String sql = "SELECT id, client_id, reg_no, odo, type, manufacturer," +
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

    public List<Vehicle> getAllVehicles() {
        String sql = "SELECT * FROM vehicle";
        return jdbcTemplate.query(sql, new VehicleRowMapper());
    }

    public void updateOdo(NewOdo newOdo) {
        String sql = "UPDATE vehicle SET odo = :odo WHERE id = :id";
        Map<String, BigInteger> paramMap = new HashMap<>();
        paramMap.put("id", newOdo.getVehId());
        paramMap.put("odo", newOdo.getNewOdoValue());
        jdbcTemplate.update(sql, paramMap);
    }

    public List<OneVehicle> oneVehicle(BigInteger vehicleId) {
        String sql = "Select id, reg_no, manufacturer, model from vehicle Where id=:vehicleId";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("vehicleId", vehicleId);
        return jdbcTemplate.query(sql, paraMap, new OneVehicleRowMapper());
    }


}
