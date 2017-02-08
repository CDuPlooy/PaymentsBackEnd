
package com.oneconnectgroup.payuapp.payu;

public enum PayloadStatusEnum {

    NOT_STARTED,
    NEW,
    STAGED,
    PROCESSING,
    SUCCESSFUL,
    FAILED,
    TIMEOUT,
    EXPIRED,
    AWAITING_PAYMENT,
    PARTIAL_PAYMENT,
    OVER_PAYMENT,
    LATE_PAYMENT;

    public String value() {
        return name();
    }

    public static PayloadStatusEnum fromValue(String v) {
        return valueOf(v);
    }

}
