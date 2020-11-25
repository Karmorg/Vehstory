package com.example.demo.controller;

import com.example.demo.Client;
import com.example.demo.Vehicle;
import com.example.demo.service.ClientService;
import com.example.demo.service.ServiceService;
import com.example.demo.service.VehicleService;
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

    @PostMapping ("register")
    public void createClient (@RequestBody Client client){
        clientService.createClient(client.getName(), client.geteMail());
    }

    @PostMapping("addVehicle")
    public void createVechile(@RequestBody Vehicle vehicle){
        vehicleService.createVehicle(vehicle);
    }

//    @GetMapping("myVehicle")
//    public List getMyVehicle(){
    //    return vehicleService.getMyVehicle();
    //}

    @PutMapping("deleteVehicle")
    public void deleteVehicle(BigInteger id){
   //     vehicleService.deleteVehicle(id);
    }

    @GetMapping("serviceList")
    public List getServiceList(){
        return serviceService.getServiceList();
    }


}
