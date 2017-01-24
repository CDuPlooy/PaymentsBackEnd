package com.oneconnect.payments.masterpass;

import java.io.Serializable;

/**
 * Created by aubreymalabie on 1/23/17.
 */

public class CodeResponseDTO implements Serializable{
    private Long expiryDate;
    private String code;

    public Long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
