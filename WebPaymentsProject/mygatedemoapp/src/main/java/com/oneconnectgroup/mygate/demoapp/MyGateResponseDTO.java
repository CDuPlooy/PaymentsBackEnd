package com.oneconnectgroup.mygate.demoapp;

/**
 * Created by aubreymalabie on 2/2/17.
 */

public class MyGateResponseDTO {
    private int statusCode;
    private String message, html;

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

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
