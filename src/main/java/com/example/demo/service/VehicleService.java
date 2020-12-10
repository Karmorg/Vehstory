package com.example.demo.service;

import com.example.demo.*;
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


    public void createVehicle(NewVehicle newVehicle, BigInteger clientIdBI1) {
        Vehicle vehicle = new Vehicle();
        vehicle.setRegNo(newVehicle.getRegNo());
        vehicle.setModel(newVehicle.getModel());
        vehicle.setClientId(clientIdBI1);
        vehicle.setManufactorer(newVehicle.getManufactorer());
        vehicle.setFuel(newVehicle.getFuel());
        vehicle.setkW(newVehicle.getkW());
        vehicle.setOdo(newVehicle.getOdo());
        vehicle.setType(newVehicle.getType());
        vehicle.setYear(newVehicle.getYear());
        vehicle.setActive(newVehicle.getActive());

        BigInteger vehId = vehicleRepository.createVehicle(vehicle);


        List<OneService> serviceIdList = serviceRepository.serviceList();
        for (OneService s : serviceIdList
        ) {
            SelectedService selectedService = new SelectedService(vehId, s.getId(),
                    null, null, null, false);
            selectedServiceRepository.insertSelectedService(selectedService);
        }


    }

    public List<Vehicle> getMyVehicle(BigInteger clientID) {
        return vehicleRepository.getMyVehicles(clientID);
    }

    public void deleteVehicle(BigInteger id) {
        vehicleRepository.updateVehicleStatus(id);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.getAllVehicles();
    }

    public void updateOdo(NewOdo newOdo) {
        vehicleRepository.updateOdo(newOdo);
    }

    public List<OneVehicle> oneVehicle(BigInteger vehicleId) {
        return vehicleRepository.oneVehicle(vehicleId);
    }

}
