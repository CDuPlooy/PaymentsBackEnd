package com.oneconnect.payments.masterpass;

/**
 * Created by aubreymalabie on 1/23/17.
 */

public class CardInfo {

    private String cardType;

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    private String binLast4;

    public String getBinLast4() {
        return this.binLast4;
    }

    public void setBinLast4(String binLast4) {
        this.binLast4 = binLast4;
    }

    private String accountType;

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }


}
