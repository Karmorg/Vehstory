package com.example.demo.repository;

import com.example.demo.OneService;
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

    public List<OneService> serviceList(){
        String sql="SELECT id FROM service_list";
        Map paramMap=new HashMap<>();
        List<OneService> serviceList=jdbcTemplate.queryForList(sql,paramMap);
        return serviceList;

    }


}
