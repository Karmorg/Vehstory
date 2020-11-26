package com.example.demo.service;

import com.example.demo.OneService;
import com.example.demo.SelectedService;
import com.example.demo.Vehicle;
import com.example.demo.repository.SelectedServiceRepository;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private SelectedServiceRepository selectedServiceRepository;
    @Autowired
    private ServiceRepository serviceRepository;


    public void createVehicle(Vehicle vehicle) {
        BigInteger vehId = vehicleRepository.createVehicle(vehicle);
        List<OneService> serviceIdList = serviceRepository.serviceList();
        for (OneService s : serviceIdList
        ) {
            SelectedService selectedService = new SelectedService(vehId, s.getId(), null, null, null, false);
            selectedServiceRepository.insertSelectedService(selectedService);
        }


    }

    public List<Vehicle> getMyVehicle(BigInteger clientID) {
        return vehicleRepository.getMyVehicles(clientID);
    }

    public void deleteVehicle(BigInteger id) {
        vehicleRepository.updateVehicleStatus(id);
    }

}
