package com.oneconnect.payments.masterpass;

import com.googlecode.objectify.annotation.Entity;

/**
 * Created by aubreymalabie on 1/23/17.
 */

@Entity
public class MasterPassRequestDTO {
    private int requestType;
    public static final int GET_CODE = 1, QUERY_CODE = 2;
    private double amount;
    private String merchantReference, shortDescription, productURL, limitBasket;
    private long expiryDate;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }

    public String getLimitBasket() {
        return limitBasket;
    }

    public void setLimitBasket(String limitBasket) {
        this.limitBasket = limitBasket;
    }

    public long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(long expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }
}
