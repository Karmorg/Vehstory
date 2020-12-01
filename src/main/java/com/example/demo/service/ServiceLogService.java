package com.example.demo.service;

import com.example.demo.ServiceLog;
import com.example.demo.repository.ServiceLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ServiceLogService {


    @Autowired
    private ServiceLogRepository serviceLogRepository;

    public void addServiceLog(List<ServiceLog> serviceLogList) {

        for (ServiceLog sl: serviceLogList
             ) {
            serviceLogRepository.addServiceLog(sl);
        }
    }
    public List<ServiceLog> getVehicleServiceLog(BigInteger vehicleId){
        return serviceLogRepository.getVehicleServiceLog(vehicleId);
    }
}
