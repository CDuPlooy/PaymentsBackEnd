package com.oneconnectgroup.paygatedemo;

/**
 * Created by aubreymalabie on 1/30/17.
 */

public class PayGateConstants {
    public static final String
            MERCHANT_PAYGATE_ID = "10011072130",
            ENCRYPTION_KEY = "secret",
            MERCHANT_RETURN_URL = "https://paymentsproject-156208.appspot.com/_ah/api/paygate-return",
            MERCHANT_NOTIFY_URL = "https://paymentsproject-156208.appspot.com/_ah/api/paygate-notify",
            URL = "https://secure.paygate.co.za/payweb3/",
            PAYGATE_REDIRECT_URL = URL.concat("process.trans");
    public static final String
            PAYGATE_ID = "PAYGATE_ID",
            REFERENCE = "REFERENCE",
            AMOUNT = "AMOUNT",
            CURRENCY = "CURRENCY",
            RETURN_URL = "RETURN_URL",
            TRANSACTION_DATE = "TRANSACTION_DATE",
            LOCALE = "LOCALE",
            COUNTRY = "COUNTRY",
            EMAIL = "EMAIL",
            NOTIFY_URL = "NOTIFY_URL",
            USER1 = "USER1",
            CHECKSUM = "CHECKSUM";
}
