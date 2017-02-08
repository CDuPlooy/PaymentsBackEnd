
package com.oneconnectgroup.payuapp.payu;

public enum PaymentInstrumentType {

    SVA_PAYU("SVA_PAYU"),
    CREDITCARD_PAYU("CREDITCARD_PAYU"),
    CREDITCARD_TOKEN("CREDITCARD_TOKEN"),
    CREDITCARD_VCO("CREDITCARD_VCO"),
    EFT_CROSS_BORDER("EFT_CROSS_BORDER"),
    EFT_CROSS_BORDER_PAYU("EFT_CROSS_BORDER_PAYU"),
    PAY_BY_REFERENCE("PAY_BY_REFERENCE"),
    SMART_EFT("SMART_EFT"),
    EFT_PRO("EFT_PRO"),
    EBUCKS_WEBSERVICE("EBUCKS_WEBSERVICE"),
    EBUCKS_REDIRECT("EBUCKS_REDIRECT"),
    WECHAT_CALLBACK("WECHAT_CALLBACK"),
    EFT_PAYMENT_NOTIFICATION("EFT_PAYMENT_NOTIFICATION"),
    MAGELLAN_PAYMENT_NOTIFICATION("MAGELLAN_PAYMENT_NOTIFICATION"),
    MCA_PAYMENT_NOTIFICATION("MCA_PAYMENT_NOTIFICATION"),
    BANK_ACCOUNT_PAYU("BANK_ACCOUNT_PAYU"),
    FEE_CREDIT_CARD("FEE_CREDIT_CARD"),
    RCS("RCS"),
    RCS_PLC("RCS_PLC"),
    QR_CODE("QR_CODE"),
    EWALLET("EWALLET"),
    WALLET_PAYU("WALLET_PAYU"),
    EFT_WALLET_PAYU_TOPUP("EFT_WALLET_PAYU_TOPUP"),
    SENTINEL_SECURE_3_D_LOOKUP("SENTINEL_SECURE3D_LOOKUP"),
    SENTINEL_SECURE_3_D_AUTH("SENTINEL_SECURE3D_AUTH");
    private final String value;

    PaymentInstrumentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentInstrumentType fromValue(String v) {
        for (PaymentInstrumentType c: PaymentInstrumentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
