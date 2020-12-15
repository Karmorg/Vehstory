package com.example.demo.service;

import com.example.demo.Client;
import com.example.demo.exception.ApplicationException;
import com.example.demo.repository.ClientRepository;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createClient(Client client) {
        if (client.getPassword() != null && client.geteMail() != null){
            List<String> list = clientRepository.allEmails();
            if (list.contains(client.geteMail())) {
                throw new ApplicationException("Selline e-mail on juba olemas");
            }else {
                client.setPassword(savePassword(client.getPassword()));
                clientRepository.createClient(client);
            }
        } else {
            throw new ApplicationException("Palun täida mõlemad väljad");
        }

    }

    public void deleteClient(BigInteger id) {
        clientRepository.updateClientStatus(id);
    }

    public String login(Client client) {
        if (client.getPassword() != null && client.geteMail() != null){
            if (emailExists(client.geteMail())){
                if (validate(client.geteMail(), client.getPassword())){

                    JwtBuilder builder = Jwts.builder()
                            .setExpiration(new Date(now.getTime()+1000*60*60*24*365))
                            .setIssuedAt(new Date())
                            .setIssuer("vehstory_login_service")
                            .signWith(SignatureAlgorithm.HS256, "secret")
                            .claim("clientId", getClientId(client))
                            .claim("eMail", client.geteMail());
                    return  builder.compact();
                } else {
                    throw new ApplicationException("Vale e-mail või parool.");
                }
            } else {
                throw new ApplicationException("E-mail ei ole registreeritud");
            }
        } else {
            throw new ApplicationException("Palun täida mõlemad väljad");
        }

    }
    public BigInteger getClientId (Client client){
        return clientRepository.getClientId(client);
    }

    public boolean validate (String eMail , String rawPassword){
        String encodedPassword = clientRepository.getPassword(eMail);
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public String savePassword(String password){
        return passwordEncoder.encode(password);
    }

    public Boolean emailExists (String eMailToCheck){
        return clientRepository.allEmails().contains(eMailToCheck);
    }

    private Date now = new Date();





}
