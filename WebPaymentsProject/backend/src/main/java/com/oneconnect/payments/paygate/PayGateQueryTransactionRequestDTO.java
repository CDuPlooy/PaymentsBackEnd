package com.oneconnect.payments.paygate;

/**
 * Created by aubreymalabie on 1/30/17.
 */

public class PayGateQueryTransactionRequestDTO {
    private String payGateID, payRequestID, reference, checksum;

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

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}
