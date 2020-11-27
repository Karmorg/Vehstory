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

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
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

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public BigInteger getServiceOdo() {
        return serviceOdo;
    }

    public void setServiceOdo(BigInteger serviceOdo) {
        this.serviceOdo = serviceOdo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
