package com.oneconnectgroup.paygatedemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import static com.oneconnectgroup.paygatedemo.PayGateConstants.ENCRYPTION_KEY;
import static com.oneconnectgroup.paygatedemo.PayGateConstants.MERCHANT_NOTIFY_URL;
import static com.oneconnectgroup.paygatedemo.PayGateConstants.MERCHANT_PAYGATE_ID;
import static com.oneconnectgroup.paygatedemo.PayGateConstants.MERCHANT_RETURN_URL;

/**
 * Created by aubreymalabie on 1/30/17.
 */

public class RequestDTO implements Serializable {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private String payGateID, reference, transactionDate, payMethod,
            currency, locale, country, email, returnURL, notifyURL, user1, checksum;
    private int amount;
    static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public RequestDTO() {
        transactionDate = sdf.format(new Date());
        country = "ZAF";
        currency = "ZAR";
        payGateID = MERCHANT_PAYGATE_ID;
        locale = "en";
        returnURL = MERCHANT_RETURN_URL;
        notifyURL = MERCHANT_NOTIFY_URL;
    }

    public String calculateChecksum() {
        StringBuilder sb = new StringBuilder();
        sb.append(payGateID).append(reference).append(amount);
        sb.append(currency).append(returnURL).append(transactionDate);
        sb.append(locale).append(country).append(email).append(notifyURL);
        sb.append(user1).append(ENCRYPTION_KEY);

        try {
            checksum = ChecksumUtil.getMD5Checksum(sb.toString());
            return checksum;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unable to calculate checksum");
        }

    }
     static final Logger log = Logger.getLogger(RequestDTO.class.getSimpleName());
    public String getPayGateID() {
        return payGateID;
    }

    public void setPayGateID(String payGateID) {
        this.payGateID = payGateID;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReturnURL() {
        return returnURL;
    }

    public void setReturnURL(String returnURL) {
        this.returnURL = returnURL;
    }

    public String getNotifyURL() {
        return notifyURL;
    }

    public void setNotifyURL(String notifyURL) {
        this.notifyURL = notifyURL;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
