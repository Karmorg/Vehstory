package com.example.demo.service;

import com.example.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public List getServiceList() {
        return serviceRepository.serviceList();
    }

    public void deleteService(BigInteger id) {
        serviceRepository.updateServiceStatus(id);
    }


}
