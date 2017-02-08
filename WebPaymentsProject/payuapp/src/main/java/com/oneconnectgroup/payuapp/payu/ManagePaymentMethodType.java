
package com.oneconnectgroup.payuapp.payu;

public enum ManagePaymentMethodType {

    TOKEN,
    HANDSHAKE,
    HANDSHAKE_SETUP_ACCOUNT,
    PROFILE;

    public String value() {
        return name();
    }

    public static ManagePaymentMethodType fromValue(String v) {
        return valueOf(v);
    }

}
