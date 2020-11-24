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
        String sql = "INSERT INTO client (name, e_mail) VALUE (:name, :eMail)";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("name", name);
        paramMap.put("eMail", eMail);
        jdbcTemplate.update(sql, paramMap);
    }
}
