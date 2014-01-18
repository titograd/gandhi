package com.crypto.orm.entities;

import java.io.Serializable;

public class MerchantDetails implements Serializable {

    public MerchantDetails() {
    }

    private long merchantId;
    private String bussinessName;
    private String email;
    private String firstName;
    private String secondName;
    private String phoneNumber;
    private String address;
    private String industry;
    private String postalCode;
    private String city;
    private String state;
    private String country;
    private String store;
    private String primaryWebsite;
    private String shopingCartOrPosSoftware;

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }

    public String getBussinessName() {

        return bussinessName;
    }

    public void setBussinessName(String bussinessName) {
        this.bussinessName = bussinessName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPrimaryWebsite() {
        return primaryWebsite;
    }

    public void setPrimaryWebsite(String primaryWebsite) {
        this.primaryWebsite = primaryWebsite;
    }

    public String getShopingCartOrPosSoftware() {
        return shopingCartOrPosSoftware;
    }

    public void setShopingCartOrPosSoftware(String shopingCartOrPosSoftware) {
        this.shopingCartOrPosSoftware = shopingCartOrPosSoftware;
    }
}
