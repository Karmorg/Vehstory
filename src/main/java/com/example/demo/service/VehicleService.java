package com.example.demo.service;

import com.example.demo.Vehicle;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public void createVehicle (Vehicle vehicle){
        vehicleRepository.createVehicle(vehicle);
    }

}
