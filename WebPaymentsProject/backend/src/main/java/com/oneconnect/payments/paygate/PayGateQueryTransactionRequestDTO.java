package com.oneconnect.payments.paygate;

import java.security.NoSuchAlgorithmException;

import static com.oneconnect.payments.paygate.PayGateConstants.ENCRYPTION_KEY;

/**
 * Created by aubreymalabie on 1/30/17.
 */

public class PayGateQueryTransactionRequestDTO {
    private String payGateID, payRequestID, reference, checksum;

    public String calculateChecksum() {
        StringBuilder sb = new StringBuilder();
        sb.append(payGateID).append(payRequestID).append(reference);
        sb.append(ENCRYPTION_KEY);

        try {
            checksum = ChecksumUtil.getMD5Checksum(sb.toString());
            return checksum;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unable to calculate checksum");
        }

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

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}
