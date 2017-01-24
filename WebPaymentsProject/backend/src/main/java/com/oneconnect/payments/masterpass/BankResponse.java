package com.oneconnect.payments.masterpass;

/**
 * Created by aubreymalabie on 1/23/17.
 */

public class BankResponse {
    public static final String SUCCESS = "SUCCESS",
    FAILED = "FAILED", SYSTEM_ERROR = "SYSTEM_ERROR",
            CLIENT_CANCEL = "CLIENT_CANCEL",
            CLIENT_TIMEOUT = "CLIENT_TIMEOUT",
            TRANSACTION_REJECTED = "TRANSACTION_REJECTED",
            BANK_OFFLINE = "BANK_OFFLINE",
            BANK_REJECTED = "BANK_REJECTED",
            REVERSED = "REVERSED",
            LIMIT_FAILED = "LIMIT_FAILED",
            REFUNDED = "REFUNDED";


    private Long retrievalReferenceNumber;
    private String authCode, bankResponse;

    public Long getRetrievalReferenceNumber() {
        return retrievalReferenceNumber;
    }

    public void setRetrievalReferenceNumber(Long retrievalReferenceNumber) {
        this.retrievalReferenceNumber = retrievalReferenceNumber;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getBankResponse() {
        return bankResponse;
    }

    public void setBankResponse(String bankResponse) {
        this.bankResponse = bankResponse;
    }
}
