package com.example.demo;

import java.math.BigInteger;

public class OneVehicle {
    private BigInteger id;
    private String manufacturer;
    private String model;
    private String regNo;

    public BigInteger getId() {
        return id;
    }

    public OneVehicle setId(BigInteger id) {
        this.id = id;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public OneVehicle setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OneVehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public String getRegNo() {
        return regNo;
    }

    public OneVehicle setRegNo(String regNo) {
        this.regNo = regNo;
        return this;
    }
}
