package com.oneconnect.payments.paygate;

/**
 * Created by aubreymalabie on 1/30/17.
 */

public class PayGateResponseDTO {

    private PayGateInitiateTranResponseDTO payGateInitiateTranResponse;
    private PayGateNotifyResponseDTO payGateNotifyResponse;
    private int statusCode;
    private String message;

    public PayGateInitiateTranResponseDTO getPayGateInitiateTranResponse() {
        return payGateInitiateTranResponse;
    }

    public void setPayGateInitiateTranResponse(PayGateInitiateTranResponseDTO payGateInitiateTranResponse) {
        this.payGateInitiateTranResponse = payGateInitiateTranResponse;
    }

    public PayGateNotifyResponseDTO getPayGateNotifyResponse() {
        return payGateNotifyResponse;
    }

    public void setPayGateNotifyResponse(PayGateNotifyResponseDTO payGateNotifyResponse) {
        this.payGateNotifyResponse = payGateNotifyResponse;
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
