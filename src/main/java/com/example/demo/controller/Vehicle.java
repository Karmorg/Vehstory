package com.example.demo.controller;

import java.math.BigInteger;

public class Vehicle {
    private BigInteger id;
    private String regNo;
    private BigInteger odo;
    private String type;
    private String manufactorer;
    private String model;
    private String year;
    private String fuel;
    private BigInteger kW;

    public Vehicle(BigInteger id, String regNo, BigInteger odo, String type, String manufactorer, String model, String year, String fuel, BigInteger kW, Boolean active) {
        this.id = id;
        this.regNo = regNo;
        this.odo = odo;
        this.type = type;
        this.manufactorer = manufactorer;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
        this.kW = kW;
        this.active = active;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public BigInteger getOdo() {
        return odo;
    }

    public void setOdo(BigInteger odo) {
        this.odo = odo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufactorer() {
        return manufactorer;
    }

    public void setManufactorer(String manufactorer) {
        this.manufactorer = manufactorer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public BigInteger getkW() {
        return kW;
    }

    public void setkW(BigInteger kW) {
        this.kW = kW;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private Boolean active;

}
