package com.oneconnectgroup.mygate.demoapp;

import java.io.Serializable;

/**
 * Created by aubreymalabie on 2/2/17.
 */


public class MyGateRequestDTO implements Serializable {
    private int mode;
    private String merchantID,
            applicationID,
            merchantReference,
            txtCurrencyCode,
            redirectSuccessfulURL,
            redirectFailureURL;
    private double amount;
    public static final String PARAM_MODE = "Mode",
            PARAM_APPLICATION_ID = "ApplicationID",
            PARAM_MERCHANT_ID = "MerchantID",
            PARAM_MERCHANT_REF = "MerchantReference",
            PARAM_AMOUNT = "Amount",
            PARAM_CURRENCY_CODE = "txtCurrencyCode",
            PARAM_REDIRECT_SUCCESS_URL = "RedirectSuccessfulURL",
            PARAM_REDIRECT_FAILED_URL = "RedirectFailedURL";

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public String getTxtCurrencyCode() {
        if (txtCurrencyCode == null) {
            txtCurrencyCode = "ZAR";
        }
        return txtCurrencyCode;
    }

    public void setTxtCurrencyCode(String txtCurrencyCode) {
        this.txtCurrencyCode = txtCurrencyCode;
    }

    public String getRedirectSuccessfulURL() {
        return redirectSuccessfulURL;
    }

    public void setRedirectSuccessfulURL(String redirectSuccessfulURL) {
        this.redirectSuccessfulURL = redirectSuccessfulURL;
    }

    public String getRedirectFailureURL() {
        return redirectFailureURL;
    }

    public void setRedirectFailureURL(String redirectFailureURL) {
        this.redirectFailureURL = redirectFailureURL;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
