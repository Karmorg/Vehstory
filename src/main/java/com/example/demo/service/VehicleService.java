package com.example.demo.service;

import com.example.demo.Vehicle;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    public void createVehicle(Vehicle vehicle) {
        vehicleRepository.createVehicle(vehicle);
    }

    public List<Vehicle> getMyVehicle(BigInteger clientID) {
        return vehicleRepository.getMyVehicles(clientID);
    }

    public void deleteVehicle(BigInteger id){
        vehicleRepository.updateVehicleStatus(id);
    }

}
