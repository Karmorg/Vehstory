package com.example.demo.controller;

import com.example.demo.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;


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
    @Autowired
    private ServiceLogService serviceLogService;

    @PostMapping("register")
    public void createClient(@RequestBody Client client) {
        clientService.createClient(client.getName(), client.geteMail());
    }

    @PutMapping("deleteClient")
    public void deleteClient(BigInteger id) {
        clientService.deleteClient(id);
    }


    @PostMapping("addVehicle")
    public void createVechile(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
    }

    @GetMapping("allVehicles")
    public List<Vehicle> getMyVehicle() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("myVehicles")
    public List<Vehicle> getMyVehicle(BigInteger clientId) {
        return vehicleService.getMyVehicle(clientId);
    }

    @PutMapping("deleteVehicle")
    public void deleteVehicle(BigInteger id) {
        vehicleService.deleteVehicle(id);
    }

    @PutMapping("updateOdo")
    public void updateOdo (@RequestBody NewOdo newOdoValue){
        vehicleService.updateOdo(newOdoValue);
    }


    @GetMapping("serviceList")
    public List<OneService> getServiceList() {
        return serviceService.getServiceList();
    }

    @PutMapping("deleteService")
    public void deleteService(@RequestBody OneService oneService) {
        serviceService.deleteService(oneService);
    }


    @GetMapping("SelectedServices")
    public List<SelectedService> getSelectedServices(BigInteger vehicleId) {
        return selectedServiceService.getSelectedService(vehicleId);
    }

    @GetMapping("VehicleSelectedServiceListDashboard")
    public List<VehicleSelectedServiceDashboard> getVehicleServiceList(BigInteger vehicleId) {
        return selectedServiceService.getServicesToDashboard(vehicleId);
    }

    @GetMapping("VehicleServiceListWithServiceName")
    public List<NameForSelectedServiceWeb> getVehicleServiceListWithServiceName(BigInteger vehicleId){
        return selectedServiceService.getVehicleServiceListWithServiceName(vehicleId);
    }

    @PutMapping("updateSelectedService")
    public void updateSelectedService(@RequestBody List<SelectedService> selectedServiceList) {
        selectedServiceService.updateSelectedService(selectedServiceList);
    }


    @PostMapping("addServiceLog")
    public void addServiceLog (@RequestBody List<ServiceLog> serviceLogList){
        serviceLogService.addServiceLog(serviceLogList);
    }

    @GetMapping("vehicleServiceLog")
    public List<ServiceLog> getVehicleServiceLog(BigInteger vehicleId){
        return serviceLogService.getVehicleServiceLog(vehicleId);
    }
}
