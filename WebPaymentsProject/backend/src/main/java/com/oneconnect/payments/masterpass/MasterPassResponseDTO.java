package com.oneconnect.payments.masterpass;

import com.googlecode.objectify.annotation.Entity;

import java.io.Serializable;

/**
 * Created by aubreymalabie on 1/23/17.
 */

@Entity
public class MasterPassResponseDTO implements Serializable{
    private int statusCode;
    private String message;
    private String testProperty;
    private CodeResponseDTO codeResponse;
    private CodeQueryResponseDTO codeQueryResponse;

    public CodeQueryResponseDTO getCodeQueryResponse() {
        return codeQueryResponse;
    }

    public void setCodeQueryResponse(CodeQueryResponseDTO codeQueryResponse) {
        this.codeQueryResponse = codeQueryResponse;
    }

    public CodeResponseDTO getCodeResponse() {
        return codeResponse;
    }

    public void setCodeResponse(CodeResponseDTO codeResponse) {
        this.codeResponse = codeResponse;
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

    public String getTestProperty() {
        return testProperty;
    }

    public void setTestProperty(String testProperty) {
        this.testProperty = testProperty;
    }
}
