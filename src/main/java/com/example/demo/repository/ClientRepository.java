package com.example.demo.repository;

import com.example.demo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ClientRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createClient (Client client){
        String sql = "INSERT INTO client (name, e_mail, pw, active) " +
                "VALUES (:name, :eMail, :password, :active)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", client.getName());
        paramMap.put("eMail", client.geteMail());
        paramMap.put("password", client.getPassword());
        paramMap.put("active", true);
        jdbcTemplate.update(sql, paramMap);
    }

    public String getPassword(String eMail) {
       String sql = "Select pw from client WHERE e_mail=:eMail";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("eMail", eMail);
        String password = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return password;
    }


    public void updateClientStatus(BigInteger id) {
        String sql = "UPDATE client SET active=:false WHERE id=:clientID";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("clientID", id);
        paramMap.put("false", false);
        jdbcTemplate.update(sql, paramMap);
    }


    public BigInteger getClientId(Client client) {
        String sql = "SELECT id FROM client WHERE e_mail= :eMail";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("eMail", client.geteMail());
        return jdbcTemplate.queryForObject(sql, paramMap, BigInteger.class);
    }
}
