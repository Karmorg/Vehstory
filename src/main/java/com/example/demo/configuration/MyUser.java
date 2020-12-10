package com.example.demo.configuration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MyUser myUser = (MyUser) o;
        return Objects.equals(clientId, myUser.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), clientId);
    }
}
