package com.oneconnect.payments.paygate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import static com.oneconnect.payments.paygate.PayGateConstants.ENCRYPTION_KEY;
import static com.oneconnect.payments.paygate.PayGateConstants.MERCHANT_NOTIFY_URL;
import static com.oneconnect.payments.paygate.PayGateConstants.MERCHANT_PAYGATE_ID;
import static com.oneconnect.payments.paygate.PayGateConstants.MERCHANT_RETURN_URL;

/**
 * Created by aubreymalabie on 1/30/17.
 */

public class PayGateInitiateRequestDTO implements Serializable {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private String payGateID, reference, transactionDate, payMethod,
            currency, locale, country, email, returnURL, notifyURL, user1, checksum;
    private int amount;
    static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final String
            PARM_PAYGATE_ID = "PAYGATE_ID",
            PARM_REFERENCE = "REFERENCE",
            PARM_AMOUNT = "AMOUNT",
            PARM_CURRENCY = "CURRENCY",
            PARM_RETURN_URL = "RETURN_URL",
            PARM_TRANSACTION_DATE = "TRANSACTION_DATE",
            PARM_LOCALE = "LOCALE",
            PARM_COUNTRY = "COUNTRY",
            PARM_EMAIL = "EMAIL",
            PARM_PAY_METHOD = "PAY_METHOD",
            PARM_NOTIFY_URL = "NOTIFY_URL",
            PARM_USER1 = "USER1",
            PARM_CHECKSUM = "CHECKSUM";



    public PayGateInitiateRequestDTO() {

    }

    public String calculateChecksum() {
        transactionDate = sdf.format(new Date());
        country = "ZAF";
        currency = "ZAR";
        payGateID = MERCHANT_PAYGATE_ID;
        locale = "en";
        returnURL = MERCHANT_RETURN_URL;
        notifyURL = MERCHANT_NOTIFY_URL;


        StringBuilder sb = new StringBuilder();
        sb.append(payGateID).append(reference).append(amount);
        sb.append(currency).append(returnURL).append(transactionDate);
        sb.append(locale).append(country).append(email)
                .append(payMethod)
                .append(notifyURL);
        sb.append(user1).append(ENCRYPTION_KEY);

        try {
            checksum = ChecksumUtil.getMD5Checksum(sb.toString());
            return checksum;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unable to calculate checksum");
        }

    }
    static final Logger log = Logger.getLogger(PayGateInitiateRequestDTO.class.getSimpleName());
    public String getPayGateID() {
        return payGateID;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
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
