package com.varunbehl.spring.model;

import java.math.BigInteger;

public class Owner {

    private String gymId;
    private String customerId;
    private String customerName;
    private String customerEmail;
    private BigInteger customerMobile;
    private BigInteger customerPhone;
    private String customerAddress;
    private String customerImage;
    private String customerSex;
    private String customerDob;
    private String customerPassword;
    private Boolean customerStatus;

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }


    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerImage() {
        return customerImage;
    }

    public void setCustomerImage(String customerImage) {
        this.customerImage = customerImage;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerDob() {
        return customerDob;
    }

    public void setCustomerDob(String customerDob) {
        this.customerDob = customerDob;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Boolean getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Boolean customerStatus) {
        this.customerStatus = customerStatus;
    }

    public BigInteger getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(BigInteger customerMobile) {
        this.customerMobile = customerMobile;
    }

    public BigInteger getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(BigInteger customerPhone) {
        this.customerPhone = customerPhone;
    }

}