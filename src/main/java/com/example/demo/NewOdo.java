package com.example.demo;

import java.math.BigInteger;

public class NewOdo {

    private BigInteger vehId;
    private BigInteger newOdo;

    public NewOdo(BigInteger vehId, BigInteger newOdo) {
        this.vehId = vehId;
        this.newOdo = newOdo;
    }

    public BigInteger getVehId() {
        return vehId;
    }

    public void setVehId(BigInteger vehId) {
        this.vehId = vehId;
    }

    public BigInteger getNewOdo() {
        return newOdo;
    }

    public void setNewOdo(BigInteger newOdo) {
        this.newOdo = newOdo;
    }
}
