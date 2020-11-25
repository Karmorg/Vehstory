package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ClientRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createClient (String name, String eMail){
        String sql = "INSERT INTO client (name, e_mail, active) VALUES (:name, :eMail, :active)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        paramMap.put("eMail", eMail);
        paramMap.put("active", true);
        jdbcTemplate.update(sql, paramMap);
    }
}
