package com.example.demo;

import java.math.BigInteger;

public class SelectedService {
    private BigInteger id;
    private BigInteger vehicleId;
    private BigInteger serviceId;
    private String pUnit;
    private BigInteger pValue;
    private String comment;
    private boolean active;

    public SelectedService(BigInteger id, BigInteger vehicleId, BigInteger serviceId,
                           String pUnit, BigInteger pValue, String comment, boolean active) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.serviceId = serviceId;
        this.pUnit = pUnit;
        this.pValue = pValue;
        this.comment = comment;
        this.active = active;
    }

    public SelectedService(BigInteger vehicleId, BigInteger serviceId, String pUnit, BigInteger pValue, String comment, boolean active) {
        this.vehicleId = vehicleId;
        this.serviceId = serviceId;
        this.pUnit = pUnit;
        this.pValue = pValue;
        this.comment = comment;
        this.active = active;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

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
