package com.oneconnect.payments.masterpass;

import java.io.Serializable;

/**
 * Created by aubreymalabie on 1/23/17.
 */

public class CodeQueryResponseDTO implements Serializable{
    String amountString, merchantReference, merchantName, shortDescription, productURL, extra;
    Boolean useOnce;
    Long expiryDate;

    public String getAmountString() {
        return amountString;
    }

    public void setAmountString(String amountString) {
        this.amountString = amountString;
    }

    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
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

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Boolean getUseOnce() {
        return useOnce;
    }

    public void setUseOnce(Boolean useOnce) {
        this.useOnce = useOnce;
    }

    public Long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }
}
