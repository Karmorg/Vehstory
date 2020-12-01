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

    public SelectedService(BigInteger id, String pUnit, BigInteger pValue, String comment, boolean active) {
        this.id = id;
        this.pUnit = pUnit;
        this.pValue = pValue;
        this.comment = comment;
        this.active = active;
    }

    public SelectedService() {
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

    public SelectedService setVehicleId(BigInteger vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public BigInteger getServiceId() {
        return serviceId;
    }

    public SelectedService setServiceId(BigInteger serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public String getpUnit() {
        return pUnit;
    }

    public SelectedService setpUnit(String pUnit) {
        this.pUnit = pUnit;
        return this;
    }

    public BigInteger getpValue() {
        return pValue;
    }

    public SelectedService setpValue(BigInteger pValue) {
        this.pValue = pValue;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public SelectedService setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public SelectedService setActive(boolean active) {
        this.active = active;
        return this;
    }
}
