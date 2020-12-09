package com.example.demo.configuration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.math.BigInteger;
import java.util.Collection;

public class MyUser extends User {
    private Integer clientId;
    public MyUser(String username, String password, Integer clientId, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.clientId = clientId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public MyUser setClientId(Integer clientId) {
        this.clientId = clientId;
        return this;
    }
}
