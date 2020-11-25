package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ServiceRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List serviceList(){
        String sql="SELECT service FROM service_list";
        Map paramMap=new HashMap<>();
        List<String> serviceList=jdbcTemplate.queryForList(sql,paramMap);
        return serviceList;

    }


}
