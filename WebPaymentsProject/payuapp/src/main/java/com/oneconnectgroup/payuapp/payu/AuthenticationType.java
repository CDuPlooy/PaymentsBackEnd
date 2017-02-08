
package com.oneconnectgroup.payuapp.payu;


public enum AuthenticationType {

    NA,
    HANDSHAKE,
    TOKEN,
    VCO;

    public String value() {
        return name();
    }

    public static AuthenticationType fromValue(String v) {
        return valueOf(v);
    }

}
