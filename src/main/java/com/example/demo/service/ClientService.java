package com.example.demo.service;

import com.example.demo.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createClient(Client client) {
        client.setPassword(savePassword(client.getPassword()));
        clientRepository.createClient(client);
    }

    public void deleteClient(BigInteger id) {
        clientRepository.updateClientStatus(id);
    }

    public String login(Client client) {
        if (validate(client.getName(), client.getPassword())){
            return "Hästi";
        } else {
            return "Vale parool või e-mail";
        }
    }

    public boolean validate (String userName, String rawPassword){
        String encodedPassword = clientRepository.getPassword(userName);
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public String savePassword(String password){
        return passwordEncoder.encode(password);
    }

}
