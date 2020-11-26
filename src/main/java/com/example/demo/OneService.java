package com.example.demo;

import java.math.BigInteger;

public class OneService {

    private BigInteger id;
    private String service;
    private Boolean active;


    public OneService(BigInteger id, String service, Boolean active) {
        this.id = id;
        this.service = service;
        this.active = active;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
