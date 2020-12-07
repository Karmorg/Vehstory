package com.example.demo.service;

import com.example.demo.Client;
import com.example.demo.repository.ClientRepository;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;

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
        if (validate(client.geteMail(), client.getPassword())){

            JwtBuilder builder = Jwts.builder()
                .setExpiration(new Date(now.getTime()+1000*60*60*24))
                .setIssuedAt(new Date())
                .setIssuer("vehstory_login_service")
                .signWith(SignatureAlgorithm.HS256, "secret")
                .claim("name", client.getName());
            return  builder.compact();
        } else {
            return "Vale parool või e-mail";
        }
    }

    public boolean validate (String eMail , String rawPassword){
        String encodedPassword = clientRepository.getPassword(eMail);
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public String savePassword(String password){
        return passwordEncoder.encode(password);
    }

    private Date now = new Date();





}
