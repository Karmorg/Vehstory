package com.example.demo.service;

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
}
