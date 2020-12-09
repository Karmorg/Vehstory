package com.example.demo;

import java.math.BigInteger;
import java.util.Date;

public class ServiceLog {

    private Date logDate;
    private BigInteger vehicleId;
    private BigInteger serviceId;
    private String serviceName;
    private Date serviceDate;
    private BigInteger serviceOdo;
    private String comment;
    private Boolean active;

    public ServiceLog() {
    }

    public ServiceLog(Date logDate, BigInteger vehicleId,
                      String serviceName, Date serviceDate, BigInteger serviceOdo,
                      String comment) {
        this.logDate = logDate;
        this.vehicleId = vehicleId;
        this.serviceName = serviceName;
        this.serviceDate = serviceDate;
        this.serviceOdo = serviceOdo;
        this.comment = comment;
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

    public String getServiceName() {
        return serviceName;
    }

    public ServiceLog setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
