
package com.oneconnectgroup.payuapp.payu;

public enum LookupTransactionType {

    TOKEN,
    HANDSHAKE,
    PAYMENT_METHODS,
    SECRET_QUESTIONS,
    ACCOUNT;

    public String value() {
        return name();
    }

    public static LookupTransactionType fromValue(String v) {
        return valueOf(v);
    }

}
