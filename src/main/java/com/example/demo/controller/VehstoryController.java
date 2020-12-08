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
    @PostMapping("public/register")
    public void createClient(@RequestBody Client client) {
        clientService.createClient(client);
    }

    @CrossOrigin
    @PostMapping ("public/login")
    public String login (@RequestBody Client client){
        return clientService.login(client);
    }

    @CrossOrigin
    @PutMapping("deleteClient")
    public void deleteClient(BigInteger id) {
        clientService.deleteClient(id);
    }


    @CrossOrigin
    @PostMapping("client/addVehicle")
    public void createVechile(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
    }

    @CrossOrigin
    @GetMapping("public/allVehicles")
    public List<Vehicle> getMyVehicle() {
        return vehicleService.getAllVehicles();
    }

    @CrossOrigin
    @GetMapping("client/myVehicles")
    public List<Vehicle> getMyVehicle(BigInteger clientId) {
        return vehicleService.getMyVehicle(clientId);
    }

    @CrossOrigin
    @GetMapping("client/oneVehicle")
    public List<OneVehicle> oneVehicle(BigInteger vehicleId) {
        return vehicleService.oneVehicle(vehicleId);
    }

    @CrossOrigin
    @PutMapping("client/deleteVehicle")
    public void deleteVehicle(BigInteger id) {
        vehicleService.deleteVehicle(id);
    }

    @CrossOrigin
    @PutMapping("client/updateOdo")
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
    @GetMapping("client/VehicleSelectedServiceListDashboard")
    public List<VehicleSelectedServiceDashboard> getVehicleServiceList(BigInteger vehicleId) {
        return selectedServiceService.getServicesToDashboard(vehicleId);
    }

    @CrossOrigin
    @GetMapping("client/VehicleServiceListWithServiceName")
    public List<NameForSelectedServiceWeb> getVehicleServiceListWithServiceName(BigInteger vehicleId){
        return selectedServiceService.getVehicleServiceListWithServiceName(vehicleId);
    }

    @CrossOrigin
    @PutMapping("client/updateSelectedService")
    public void updateSelectedService(@RequestBody List<SelectedService> selectedServiceList) {
        selectedServiceService.updateSelectedService(selectedServiceList);
    }

    @CrossOrigin
    @PostMapping("client/addServiceLog")
    public void addServiceLog (@RequestBody List<ServiceLog> serviceLogList){
        serviceLogService.addServiceLog(serviceLogList);
    }

    @CrossOrigin
    @GetMapping("vehicleServiceLog")
    public List<ServiceLog> getVehicleServiceLog(BigInteger vehicleId){
        return serviceLogService.getVehicleServiceLog(vehicleId);
    }
}
