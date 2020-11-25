package com.example.demo;

import java.math.BigInteger;

public class SelectedService {
    private BigInteger vehicleId;
    private BigInteger serviceId;
    private String pUnit;
    private BigInteger pValue;
    private String comment;
    private boolean active;


    public BigInteger getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(BigInteger vehicleId) {
        this.vehicleId = vehicleId;
    }

    public BigInteger getServiceId() {
        return serviceId;
    }

    public void setServiceId(BigInteger serviceId) {
        this.serviceId = serviceId;
    }

    public String getpUnit() {
        return pUnit;
    }

    public void setpUnit(String pUnit) {
        this.pUnit = pUnit;
    }

    public BigInteger getpValue() {
        return pValue;
    }

    public void setpValue(BigInteger pValue) {
        this.pValue = pValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
