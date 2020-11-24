package com.example.demo.controller;

import com.example.demo.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehstoryController {

    @Autowired
    private ClientService clientService;

    @PostMapping ("register")
    public void createClient (@RequestBody Client client){
        clientService.createClient(client.getName(), client.geteMail());
    }
}
