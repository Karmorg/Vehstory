package com.example.demo.service;

import com.example.demo.Client;
import com.example.demo.repository.ClientRepository;
import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public String validateClient (Client client){
        String encodedPassword = clientRepository.validateClient(client.geteMail());
        if(passwordEncoder.matches(client.getPassword(), encodedPassword)){
            
            return "Kõik ok";
        }else{
            return "Proovi uuesti";
        }

    }

    public void createClient(Client client) {
        String encodedPassword=passwordEncoder.encode(client.getPassword());
        clientRepository.createClient(client, encodedPassword);
    }

    public void deleteClient(BigInteger id) {
        clientRepository.updateClientStatus(id);
    }

}
