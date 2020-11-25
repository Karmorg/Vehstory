package com.example.demo.controller;

import com.example.demo.Client;
import com.example.demo.Vehicle;
import com.example.demo.service.ClientService;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehstoryController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private VehicleService vehicleService;

    @PostMapping ("register")
    public void createClient (@RequestBody Client client){
        clientService.createClient(client.getName(), client.geteMail());
    }

    @PostMapping("addVehicle")
    public void createVechile(@RequestBody Vehicle vehicle){
        vehicleService.createVehicle(vehicle);
    }


}
