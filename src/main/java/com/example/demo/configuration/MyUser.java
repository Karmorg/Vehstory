package com.example.demo.configuration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.math.BigInteger;
import java.util.Collection;

public class MyUser extends User {
    private BigInteger clientId;
    public MyUser(String username, String password, BigInteger clientId, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.clientId = getClientId();
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public MyUser setClientId(BigInteger clientId) {
        this.clientId = clientId;
        return this;
    }
}
