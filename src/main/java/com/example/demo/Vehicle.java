package com.example.demo;

import java.math.BigInteger;

public class Vehicle {

    private  BigInteger vehId;
    private BigInteger clientId;
    private String regNo;
    private BigInteger odo;
    private String type;
    private String manufactorer;
    private String model;
    private String year;
    private String fuel;
    private BigInteger kW;
    private Boolean active;

    public Vehicle() {
    }

    public Vehicle(BigInteger vehId, BigInteger clientId, String regNo,
                   BigInteger odo, String type, String manufactorer, String model,
                   String year, String fuel, BigInteger kW, Boolean active) {
        this.vehId = vehId;
        this.clientId = clientId;
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

    public BigInteger getVehId() {
        return vehId;
    }

    public Vehicle setVehId(BigInteger vehId) {
        this.vehId = vehId;
        return this;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public Vehicle setClientId(BigInteger clientId) {
        this.clientId = clientId;
        return this;
    }

    public String getRegNo() {
        return regNo;
    }

    public Vehicle setRegNo(String regNo) {
        this.regNo = regNo;
        return this;
    }

    public BigInteger getOdo() {
        return odo;
    }

    public Vehicle setOdo(BigInteger odo) {
        this.odo = odo;
        return this;
    }

    public String getType() {
        return type;
    }

    public Vehicle setType(String type) {
        this.type = type;
        return this;
    }

    public String getManufactorer() {
        return manufactorer;
    }

    public Vehicle setManufactorer(String manufactorer) {
        this.manufactorer = manufactorer;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Vehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public String getYear() {
        return year;
    }

    public Vehicle setYear(String year) {
        this.year = year;
        return this;
    }

    public String getFuel() {
        return fuel;
    }

    public Vehicle setFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public BigInteger getkW() {
        return kW;
    }

    public Vehicle setkW(BigInteger kW) {
        this.kW = kW;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public Vehicle setActive(Boolean active) {
        this.active = active;
        return this;
    }
}
