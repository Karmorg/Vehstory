package com.example.demo.controller;

import com.example.demo.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;


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

    @CrossOrigin
    @PostMapping("register")
    public void createClient(@RequestBody Client client) {
        clientService.createClient(client);
    }

    @CrossOrigin
    @PostMapping ("login")
    public String login (@RequestBody Client client){
        return clientService.login(client);
    }

    @CrossOrigin
    @PutMapping("deleteClient")
    public void deleteClient(BigInteger id) {
        clientService.deleteClient(id);
    }


    @CrossOrigin
    @PostMapping("addVehicle")
    public void createVechile(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
    }

    @CrossOrigin
    @GetMapping("allVehicles")
    public List<Vehicle> getMyVehicle() {
        return vehicleService.getAllVehicles();
    }

    @CrossOrigin
    @GetMapping("myVehicles")
    public List<Vehicle> getMyVehicle(BigInteger clientId) {
        return vehicleService.getMyVehicle(clientId);
    }

    @GetMapping("oneVehicle")
    public List<OneVehicle> oneVehicle(BigInteger vehicleId) {
        return vehicleService.oneVehicle(vehicleId);
    }

    @CrossOrigin
    @PutMapping("deleteVehicle")
    public void deleteVehicle(BigInteger id) {
        vehicleService.deleteVehicle(id);
    }

    @CrossOrigin
    @PutMapping("updateOdo")
    public void updateOdo (@RequestBody NewOdo newOdoValue){
        vehicleService.updateOdo(newOdoValue);
    }


    @CrossOrigin
    @GetMapping("serviceList")
    public List<OneService> getServiceList() {
        return serviceService.getServiceList();
    }

    @CrossOrigin
    @PutMapping("deleteService")
    public void deleteService(@RequestBody OneService oneService) {
        serviceService.deleteService(oneService);
    }

    @CrossOrigin
    @GetMapping("SelectedServices")
    public List<SelectedService> getSelectedServices(BigInteger vehicleId) {
        return selectedServiceService.getSelectedService(vehicleId);
    }

    @CrossOrigin
    @GetMapping("VehicleSelectedServiceListDashboard")
    public List<VehicleSelectedServiceDashboard> getVehicleServiceList(BigInteger vehicleId) {
        return selectedServiceService.getServicesToDashboard(vehicleId);
    }

    @CrossOrigin
    @GetMapping("VehicleServiceListWithServiceName")
    public List<NameForSelectedServiceWeb> getVehicleServiceListWithServiceName(BigInteger vehicleId){
        return selectedServiceService.getVehicleServiceListWithServiceName(vehicleId);
    }

    @CrossOrigin
    @PutMapping("updateSelectedService")
    public void updateSelectedService(@RequestBody List<SelectedService> selectedServiceList) {
        selectedServiceService.updateSelectedService(selectedServiceList);
    }

    @CrossOrigin
    @PostMapping("addServiceLog")
    public void addServiceLog (@RequestBody List<ServiceLog> serviceLogList){
        serviceLogService.addServiceLog(serviceLogList);
    }

    @CrossOrigin
    @GetMapping("vehicleServiceLog")
    public List<ServiceLog> getVehicleServiceLog(BigInteger vehicleId){
        return serviceLogService.getVehicleServiceLog(vehicleId);
    }
}
