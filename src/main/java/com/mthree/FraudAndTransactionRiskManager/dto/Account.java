package com.mthree.FraudAndTransactionRiskManager.dto;

import org.json.simple.JSONObject;

import java.math.BigDecimal;

//unfinished
public class Account {

    private String id;
    private String name;

    private BigDecimal available;

    private String current;

    private String currencyCode;
    private String mask;
    private String type;
    private String subType;
    private String country;
    private String city;

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAvailableAsString() {
        return available.toString();
    }
    public BigDecimal getAvailable(){
        return available;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getCurrent() {
        return current;
    }

    public String getMask() {
        return mask;
    }

    public String getSubType() {
        return subType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public void setAvailable(String available) {
        this.available = new BigDecimal(available);
    }
    public void setAvailable(BigDecimal available) {
        this.available = available;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", current='" + current + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", mask='" + mask + '\'' +
                ", type='" + type + '\'' +
                ", subType='" + subType + '\'' +
                '}';
    }
}
