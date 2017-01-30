package com.oneconnect.payments.paygate;

/**
 * Created by aubreymalabie on 1/30/17.
 */

public class PayGateInitiateTranResponseDTO {
    private int statusCode;
    private String payGateID, payRequestID, reference, message, checkSum;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getPayGateID() {
        return payGateID;
    }

    public void setPayGateID(String payGateID) {
        this.payGateID = payGateID;
    }

    public String getPayRequestID() {
        return payRequestID;
    }

    public void setPayRequestID(String payRequestID) {
        this.payRequestID = payRequestID;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }
}
