package com.example.demo.service;

import com.example.demo.ServiceLog;
import com.example.demo.repository.ServiceLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class ServiceLogService {


    @Autowired
    private ServiceLogRepository serviceLogRepository;

    public void addServiceLog(List<ServiceLog> serviceLogList) {

        for (ServiceLog sl: serviceLogList
             ) {
            if (sl.getServiceOdo() != null || sl.getServiceDate() != null){
                if (sl.getServiceDate() == null){
                    sl.setServiceDate(new Date());
                }
                sl.setLogDate(new Date());
                sl.setActive(true);
                serviceLogRepository.addServiceLog(sl);
            }

        }
    }
    public List<ServiceLog> getVehicleServiceLog(BigInteger vehicleId){
        return serviceLogRepository.getVehicleServiceLog(vehicleId);
    }
}
