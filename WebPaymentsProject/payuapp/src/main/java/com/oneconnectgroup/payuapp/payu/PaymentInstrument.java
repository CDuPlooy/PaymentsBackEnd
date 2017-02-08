
package com.oneconnectgroup.payuapp.payu;

public enum PaymentInstrument {

    CREDITCARD("CREDITCARD"),
    CREDITCARD_TOKEN("CREDITCARD_TOKEN"),
    CREDITCARD_PAYU("CREDITCARD_PAYU"),
    WALLET("WALLET"),
    SVA("SVA"),
    DEBITCARD("DEBITCARD"),
    LOYALTY("LOYALTY"),
    EBUCKS("EBUCKS"),
    EFT("EFT"),
    EFT_PASS("EFT_PASS"),
    UKASH("UKASH"),
    BANKTRANSFER("BANKTRANSFER"),
    BANK_ACCOUNT("BANK_ACCOUNT"),
    THIRDPARTY("THIRDPARTY"),
    AUTOPAY("AUTOPAY"),
    VOUCHER("VOUCHER"),
    INSTANTMONEY("INSTANTMONEY"),
    DISCOVERYMILES("DISCOVERYMILES"),
    EVENT_RELOAD("EVENT_RELOAD"),
    WICODE("WICODE"),
    GLOBALPAY("GLOBALPAY"),
    SOULSTACE("SOULSTACE"),
    PAYPAL("PAYPAL"),
    MASTERPASS("MASTERPASS"),
    SBUX("SBUX"),
    CARD_STORE_PAYU("CARD_STORE_PAYU"),
    WALLET_PAYU("WALLET_PAYU"),
    WALLET_PAYU_AUTHENTICATION("WALLET_PAYU_AUTHENTICATION"),
    WALLET_PAYU_SETUP_ORDER("WALLET_PAYU_SETUP_ORDER"),
    EWALLET("EWALLET"),
    RCS("RCS"),
    QR_CODE("QR_CODE"),
    VAS("VAS"),
    SENTINEL("SENTINEL"),
    SECURE_3_D_LOOKUP("SECURE_3D_LOOKUP"),
    SECURE_3_D_AUTH("SECURE_3D_AUTH"),
    SECURE_3_D("SECURE_3D"),
    FRAUD("FRAUD"),
    CROSS_BORDER_CREATE_ACCOUNT("CROSS_BORDER_CREATE_ACCOUNT"),
    CROSS_BORDER_BENEFICIARY("CROSS_BORDER_BENEFICIARY"),
    CROSS_BORDER_GET_DETAILS("CROSS_BORDER_GET_DETAILS"),
    IPN("IPN"),
    SVA_VALIDATE("SVA_VALIDATE"),
    FEE("FEE"),
    SMS_NOTIFICATION("SMS_NOTIFICATION"),
    ADVISORY("ADVISORY");
    private final String value;

    PaymentInstrument(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentInstrument fromValue(String v) {
        for (PaymentInstrument c: PaymentInstrument.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
