package com.oneconnectgroup.paygatedemo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aubreymalabie on 2/8/17.
 */

public class PayMethod implements Serializable{
    private String code, description;

    public PayMethod(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static List<PayMethod> getList() {
        List<PayMethod> list = new ArrayList<>();
        PayMethod m1 = new PayMethod("CC", "Credit Card");
        PayMethod m2 = new PayMethod("DC", "Debit Card");
        PayMethod m3 = new PayMethod("EW", "eWallet");
        PayMethod m4 = new PayMethod("BT", "Bank Transfer");
        PayMethod m5 = new PayMethod("CV", "Cash Voucher");
        PayMethod m6 = new PayMethod("PC", "Pre-Paid Card");
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
        list.add(m6);
        return list;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
