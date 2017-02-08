package com.oneconnect.payments.util;

/**
 * Created by aubreymalabie on 1/19/17.
 */

public class TransactionResponseDTO {

    private int statusCode;
    private  String message, payRequestID;
    int transactionStatus;

    public String getPayRequestID() {
        return payRequestID;
    }

    public void setPayRequestID(String payRequestID) {
        this.payRequestID = payRequestID;
    }

    public int getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(int transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
