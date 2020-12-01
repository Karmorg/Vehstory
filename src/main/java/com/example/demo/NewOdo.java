package com.example.demo;

import java.math.BigInteger;

public class NewOdo {

    private BigInteger vehId;
    private BigInteger newOdoValue;

    public NewOdo(BigInteger vehId, BigInteger newOdoValue) {
        this.vehId = vehId;
        this.newOdoValue = newOdoValue;
    }

    public BigInteger getVehId() {
        return vehId;
    }

    public void setVehId(BigInteger vehId) {
        this.vehId = vehId;
    }

    public BigInteger getNewOdoValue() {
        return newOdoValue;
    }

    public void setNewOdoValue(BigInteger newOdoValue) {
        this.newOdoValue = newOdoValue;
    }
}
