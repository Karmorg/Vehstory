package com.example.demo;

import java.math.BigInteger;

public class NewVehicle {

    private BigInteger vehId;
    private String regNo;
    private BigInteger odo;
    private String type;
    private String manufactorer;
    private String model;
    private String year;
    private String fuel;
    private BigInteger kW;
    private Boolean active;


    public BigInteger getVehId() {
        return vehId;
    }

    public NewVehicle setVehId(BigInteger vehId) {
        this.vehId = vehId;
        return this;
    }

    public String getRegNo() {
        return regNo;
    }

    public NewVehicle setRegNo(String regNo) {
        this.regNo = regNo;
        return this;
    }

    public BigInteger getOdo() {
        return odo;
    }

    public NewVehicle setOdo(BigInteger odo) {
        this.odo = odo;
        return this;
    }

    public String getType() {
        return type;
    }

    public NewVehicle setType(String type) {
        this.type = type;
        return this;
    }

    public String getManufactorer() {
        return manufactorer;
    }

    public NewVehicle setManufactorer(String manufactorer) {
        this.manufactorer = manufactorer;
        return this;
    }

    public String getModel() {
        return model;
    }

    public NewVehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public String getYear() {
        return year;
    }

    public NewVehicle setYear(String year) {
        this.year = year;
        return this;
    }

    public String getFuel() {
        return fuel;
    }

    public NewVehicle setFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public BigInteger getkW() {
        return kW;
    }

    public NewVehicle setkW(BigInteger kW) {
        this.kW = kW;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public NewVehicle setActive(Boolean active) {
        this.active = active;
        return this;
    }
}
