package com.oneconnect.payments.util;

/**
 * Created by aubreymalabie on 1/19/17.
 */

public class TransactionResponseDTO {

    private int statusCode;
    private  String message;

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
