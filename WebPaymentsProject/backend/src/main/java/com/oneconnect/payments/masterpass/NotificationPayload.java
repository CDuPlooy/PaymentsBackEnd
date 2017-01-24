package com.oneconnect.payments.masterpass;

import java.io.Serializable;

/**
 * Created by aubreymalabie on 1/23/17.
 */

public class NotificationPayload implements Serializable {
    private int transactionId;

    public int getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    private String reference;

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    private double amount;

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private String currencyCode;

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private BankResponse bankResponse;

    public BankResponse getBankResponse() {
        return this.bankResponse;
    }

    public void setBankResponse(BankResponse bankResponse) {
        this.bankResponse = bankResponse;
    }

    private String code;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private ClientContact clientContact;

    public ClientContact getClientContact() {
        return this.clientContact;
    }

    public void setClientContact(ClientContact clientContact) {
        this.clientContact = clientContact;
    }

    private ClientBilling clientBilling;

    public ClientBilling getClientBilling() {
        return this.clientBilling;
    }

    public void setClientBilling(ClientBilling clientBilling) {
        this.clientBilling = clientBilling;
    }

    private ClientShipping clientShipping;

    public ClientShipping getClientShipping() {
        return this.clientShipping;
    }

    public void setClientShipping(ClientShipping clientShipping) {
        this.clientShipping = clientShipping;
    }

    private CardInfo cardInfo;

    public CardInfo getCardInfo() {
        return this.cardInfo;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

}
