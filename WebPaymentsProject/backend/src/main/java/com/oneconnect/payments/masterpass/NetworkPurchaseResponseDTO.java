package com.oneconnect.payments.masterpass;

/**
 * Created by aubreymalabie on 1/25/17.
 */

public class NetworkPurchaseResponseDTO {

    int statusCode;

    long transactionReference;
    String reference, message;

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

    public long getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(long transactionReference) {
        this.transactionReference = transactionReference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
