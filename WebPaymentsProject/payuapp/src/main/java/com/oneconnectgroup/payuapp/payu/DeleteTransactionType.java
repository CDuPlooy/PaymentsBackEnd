
package com.oneconnectgroup.payuapp.payu;

public enum DeleteTransactionType {

    TOKEN;

    public String value() {
        return name();
    }

    public static DeleteTransactionType fromValue(String v) {
        return valueOf(v);
    }

}
