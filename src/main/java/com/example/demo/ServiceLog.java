package com.example.demo;

import java.math.BigInteger;
import java.util.Date;

public class ServiceLog {

    private Date logDate;
    private BigInteger vehicleId;
    private BigInteger serviceId;
    private Date serviceDate;
    private BigInteger serviceOdo;
    private String comment;
    private Boolean active;

    public ServiceLog() {
    }

    public ServiceLog(Date logDate, BigInteger vehicleId, BigInteger serviceId,
                      Date serviceDate, BigInteger serviceOdo, String comment, Boolean active) {
        this.logDate = logDate;
        this.vehicleId = vehicleId;
        this.serviceId = serviceId;
        this.serviceDate = serviceDate;
        this.serviceOdo = serviceOdo;
        this.comment = comment;
        this.active = active;
    }

    public Date getLogDate() {
        return logDate;
    }

    public ServiceLog setLogDate(Date logDate) {
        this.logDate = logDate;
        return this;
    }

    public BigInteger getVehicleId() {
        return vehicleId;
    }

    public ServiceLog setVehicleId(BigInteger vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public BigInteger getServiceId() {
        return serviceId;
    }

    public ServiceLog setServiceId(BigInteger serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public ServiceLog setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
        return this;
    }

    public BigInteger getServiceOdo() {
        return serviceOdo;
    }

    public ServiceLog setServiceOdo(BigInteger serviceOdo) {
        this.serviceOdo = serviceOdo;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public ServiceLog setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public ServiceLog setActive(Boolean active) {
        this.active = active;
        return this;
    }
}
