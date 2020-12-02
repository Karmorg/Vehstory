package com.example.demo.service;

import com.example.demo.NameForSelectedServiceWeb;
import com.example.demo.SelectedService;
import com.example.demo.VehicleSelectedServiceDashboard;
import com.example.demo.repository.SelectedServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class SelectedServiceService {

    @Autowired
    private SelectedServiceRepository selectedServiceRepository;

    public List<com.example.demo.SelectedService> getSelectedService(BigInteger vehicleId){
        return selectedServiceRepository.getSelectedService(vehicleId);
    }

    public List<com.example.demo.SelectedService> getVehicleServiceList(BigInteger vehicleId){
        return selectedServiceRepository.getVehicleServiceList(vehicleId);
    }
    public List<NameForSelectedServiceWeb> getVehicleServiceListWithServiceName(BigInteger vehicleId){
        return selectedServiceRepository.getVehicleServiceListWithServiceName(vehicleId);
    }

    public void updateSelectedService(List<SelectedService> selectedServiceList){
       for (SelectedService ss: selectedServiceList ) {
           if (ss.isActive()) {
               selectedServiceRepository.updateSelectedService(ss);
           }
       }
    }

    public List<VehicleSelectedServiceDashboard> getServicesToDashboard(BigInteger vehicleId){
        return selectedServiceRepository.getServicesToDashboard(vehicleId);
    }
}
