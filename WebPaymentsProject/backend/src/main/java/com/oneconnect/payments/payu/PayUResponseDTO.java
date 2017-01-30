package com.oneconnect.payments.payu;

import java.io.Serializable;

/**
 * Created by aubreymalabie on 1/29/17.
 */

public class PayUResponseDTO implements Serializable{
    private int statusCode;
    private String message;

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
