package com.devjulio16j.conversormoedas.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Coin {
    @SerializedName("code")
    private String code;

    @SerializedName("codein")
    private String codeIn;

    @SerializedName("name")
    private String name;

    @SerializedName("bid")
    private Float quotation;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeIn() {
        return codeIn;
    }

    public void setCodeIn(String codeIn) {
        this.codeIn = codeIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getQuotation() {
        return quotation;
    }

    public void setQuotation(float quotation) {
        this.quotation = quotation;
    }
}
