package com.example.demo.controller;

import com.example.demo.*;
import com.example.demo.service.ClientService;
import com.example.demo.service.SelectedServiceService;
import com.example.demo.service.ServiceService;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class VehstoryController {


    @Autowired
    private ClientService clientService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private ServiceService serviceService;

    @Autowired
    private SelectedServiceService selectedServiceService;

    @CrossOrigin
    @PostMapping("register")
    public void createClient(@RequestBody Client client) {
        clientService.createClient(client.getName(), client.geteMail());
    }

    @PostMapping("addVehicle")
    public void createVechile(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
    }

    @CrossOrigin
    @GetMapping("allVehicles")
    public List<Vehicle> getMyVehicle() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("myVehicle")
    public List<Vehicle> getMyVehicle(BigInteger clientID) {
        return vehicleService.getMyVehicle(clientID);
    }

    @CrossOrigin
    @PutMapping("updateOdo")
    public void updateOdo (@RequestBody NewOdo newOdo){
        vehicleService.updateOdo(newOdo);
    }

    @PutMapping("deleteVehicle")
    public void deleteVehicle(BigInteger id) {
        vehicleService.deleteVehicle(id);
    }

    @CrossOrigin
    @GetMapping("serviceList")
    public List getServiceList() {
        return serviceService.getServiceList();
    }

    @GetMapping("SelectedServices")
    public List<SelectedService> getSelectedServices(@RequestBody BigInteger vehicleId) {
        return selectedServiceService.getSelectedService(vehicleId);
    }

    @GetMapping("VehicleServiceList")
    public List<SelectedService> getVehicleServiceList(@RequestBody BigInteger vehicleId) {
        return selectedServiceService.getVehicleServiceList(vehicleId);
    }

    @PutMapping("deleteClient")
    public void deleteClient(BigInteger id) {
        clientService.deleteClient(id);
    }

    @PutMapping("deleteService")
    public void deleteService(@RequestBody OneService oneService) {
        serviceService.deleteService(oneService);
    }

    @PutMapping("updateSelectedService")
    public void updateSelectedService(@RequestBody List<SelectedService> selectedServiceList) {
        selectedServiceService.updateSelectedService(selectedServiceList);
    }
}
