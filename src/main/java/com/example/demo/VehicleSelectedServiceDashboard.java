package com.example.demo;

import java.math.BigInteger;
import java.util.Date;

public class VehicleSelectedServiceDashboard {

    private BigInteger serviceId;
    private String serviceName;
    private String pUnit;
    private BigInteger pValue;
    private Date lastSDate;
    private BigInteger lastSOdo;
    private Date nextSDate;
    private BigInteger nextSOdo;
    private Date serviceDate;
    private BigInteger serviceOdo;
    private String comment;
    private Date logDate;

    public VehicleSelectedServiceDashboard() {
    }

    public BigInteger getServiceId() {
        return serviceId;
    }

    public VehicleSelectedServiceDashboard setServiceId(BigInteger serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }

    public VehicleSelectedServiceDashboard setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public String getpUnit() {
        return pUnit;
    }

    public VehicleSelectedServiceDashboard setpUnit(String pUnit) {
        this.pUnit = pUnit;
        return this;
    }

    public BigInteger getpValue() {
        return pValue;
    }

    public VehicleSelectedServiceDashboard setpValue(BigInteger pValue) {
        this.pValue = pValue;
        return this;
    }

    public Date getLastSDate() {
        return lastSDate;
    }

    public VehicleSelectedServiceDashboard setLastSDate(Date lastSDate) {
        this.lastSDate = lastSDate;
        return this;
    }

    public BigInteger getLastSOdo() {
        return lastSOdo;
    }

    public VehicleSelectedServiceDashboard setLastSOdo(BigInteger lastSOdo) {
        this.lastSOdo = lastSOdo;
        return this;
    }

    public Date getNextSDate() {
        return nextSDate;
    }

    public VehicleSelectedServiceDashboard setNextSDate(Date nextSDate) {
        this.nextSDate = nextSDate;
        return this;
    }

    public BigInteger getNextSOdo() {
        return nextSOdo;
    }

    public VehicleSelectedServiceDashboard setNextSOdo(BigInteger nextSOdo) {
        this.nextSOdo = nextSOdo;
        return this;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public VehicleSelectedServiceDashboard setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
        return this;
    }

    public BigInteger getServiceOdo() {
        return serviceOdo;
    }

    public VehicleSelectedServiceDashboard setServiceOdo(BigInteger serviceOdo) {
        this.serviceOdo = serviceOdo;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public VehicleSelectedServiceDashboard setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Date getLogDate() {
        return logDate;
    }

    public VehicleSelectedServiceDashboard setLogDate(Date logDate) {
        this.logDate = logDate;
        return this;
    }
}
