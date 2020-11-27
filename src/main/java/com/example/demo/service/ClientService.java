package com.example.demo.service;

import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void createClient(String name, String eMail) {
        clientRepository.createClient(name, eMail);
    }

    public void deleteClient(BigInteger id) {
        clientRepository.updateClientStatus(id);
    }

}
