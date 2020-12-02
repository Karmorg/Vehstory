package com.example.demo;

import java.math.BigInteger;

public class NameForSelectedServiceWeb {
    private BigInteger id;
    private BigInteger vehicleId;
    private String serviceName;
    private String pUnit;
    private BigInteger pValue;
    private String comment;
    private boolean active;

    public NameForSelectedServiceWeb(BigInteger id, BigInteger vehicleId,
                                     String serviceName, String pUnit,
                                     BigInteger pValue, String comment,
                                     boolean active) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.serviceName = serviceName;
        this.pUnit = pUnit;
        this.pValue = pValue;
        this.comment = comment;
        this.active = active;
    }

    public NameForSelectedServiceWeb() {

    }

    public BigInteger getId() {
        return id;
    }

    public NameForSelectedServiceWeb setId(BigInteger id) {
        this.id = id;
        return this;
    }

    public BigInteger getVehicleId() {
        return vehicleId;
    }

    public NameForSelectedServiceWeb setVehicleId(BigInteger vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }

    public NameForSelectedServiceWeb setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public String getpUnit() {
        return pUnit;
    }

    public NameForSelectedServiceWeb setpUnit(String pUnit) {
        this.pUnit = pUnit;
        return this;
    }

    public BigInteger getpValue() {
        return pValue;
    }

    public NameForSelectedServiceWeb setpValue(BigInteger pValue) {
        this.pValue = pValue;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public NameForSelectedServiceWeb setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public NameForSelectedServiceWeb setActive(boolean active) {
        this.active = active;
        return this;
    }
}
