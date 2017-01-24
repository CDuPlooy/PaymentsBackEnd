package com.oneconnect.payments.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by aubreymalabie on 1/19/17.
 */

public class InitiateTransactionDTO {

    private String payGateID,reference,amount,currency = "ZAR",
    returnURL, transactionDate,locale = "en",country = "ZAF",email,
    notifyURL, user1, checkSum;
    private static final Logger log = Logger.getLogger(InitiateTransactionDTO.class.getSimpleName());
    public static final SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-dd HH:mm");

    public String getPayload() {
        StringBuilder sb = new StringBuilder();
        sb.append("PAYGATE_ID=").append(payGateID).append("&");
        sb.append("REFERENCE=").append(reference).append("&");
        sb.append("AMOUNT=").append(amount).append("&");
        sb.append("CURRENCY=").append(currency).append("&");
        sb.append("RETURN_URL=").append(returnURL).append("&");
        sb.append("TRANSACTION_DATE=").append(transactionDate).append("&");
        sb.append("LOCALE=").append(locale).append("&");
        sb.append("COUNTRY=").append(country).append("&");
        sb.append("EMAIL=").append(email).append("&");
        sb.append("NOTIFY_URL=").append(notifyURL).append("&");
        sb.append("USER1=").append(user1).append("&");
        sb.append("CHECKSUM=").append(checkSum);

        log.log(Level.INFO, sb.toString());
        return  sb.toString();

    }

    public String getPayGateID() {
        return payGateID;
    }

    public void setPayGateID(String payGateID) {
        this.payGateID = payGateID;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }

    public InitiateTransactionDTO() {
        transactionDate = sdf.format(new Date());
        log.log(Level.WARNING,"InitiateTransactionDTO constructor");
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReturnURL() {
        return returnURL;
    }

    public void setReturnURL(String returnURL) {
        this.returnURL = returnURL;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String date) {
        this.transactionDate = date;
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

    public String getCheckSum() {
        return checkSum;
    }

}
