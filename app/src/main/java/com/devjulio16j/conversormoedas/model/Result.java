package com.devjulio16j.conversormoedas.model;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("BTCBRL")
    private Coin BTCBRL;

    @SerializedName("ETHBRL")
    private Coin ETHBRL;

    @SerializedName("EURBRL")
    private Coin EURBRL;

    @SerializedName("USDBRL")
    private Coin USDBRL;

    public Coin getBTCBRL() {
        return BTCBRL;
    }

    public void setBTCBRL(Coin BTCBRL) {
        this.BTCBRL = BTCBRL;
    }

    public Coin getETHBRL() {
        return ETHBRL;
    }

    public void setETHBRL(Coin ETHBRL) {
        this.ETHBRL = ETHBRL;
    }

    public Coin getEURBRL() {
        return EURBRL;
    }

    public void setEURBRL(Coin EURBRL) {
        this.EURBRL = EURBRL;
    }

    public Coin getUSDBRL() {
        return USDBRL;
    }

    public void setUSDBRL(Coin USDBRL) {
        this.USDBRL = USDBRL;
    }
}
