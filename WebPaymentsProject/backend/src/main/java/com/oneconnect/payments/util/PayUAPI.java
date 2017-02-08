package com.oneconnect.payments.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnect.payments.payu.AdditionalInfo;
import com.oneconnect.payments.payu.Basket;
import com.oneconnect.payments.payu.CreditCard;
import com.oneconnect.payments.payu.Customer;
import com.oneconnect.payments.payu.Eft;
import com.oneconnect.payments.payu.EnterpriseAPISoapService;
import com.oneconnect.payments.payu.Fraud;
import com.oneconnect.payments.payu.LoyaltyCard;
import com.oneconnect.payments.payu.SetTransactionResponseMessage;
import com.oneconnect.payments.payu.TransactionRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by aubreymalabie on 1/28/17.
 */

public class PayUAPI {

    private EnterpriseAPISoapService service;
    private static final Logger log = Logger.getLogger(PayGateAPI.class.getName());

    static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final String
            STORE_NAME = "Staging Integration Store 3",
            USER_NAME = "Staging Integration Store 3",
            PASSWORD = "WSAUFbw6",
            SAFE_KEY = "{07F70723-1B96-4B97-B891-7BF708594EEA}",
            API = "",
            PAYMENT_METHODS = "Credit Cards, DiscoveryMiles,Ebucks\n" +
                    "AutoPay, Debit Cards, EFT," +
                    "Credit Card Debit Order," +
                    "Once Off Payment and Debit Order",
            INTEGRATION_TYPE = "Redirect Payment Page",
            MERCHANT_PRODUCT_TYPE = "PayU Business",
            ENVIRONMENT = "staging.payu.co.za";


    public PayUAPI() {
        service = new EnterpriseAPISoapService();
//        BindingProvider prov = (BindingProvider)service.getEnterpriseAPISoapPort();
//        prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, USER_NAME);
//        prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, PASSWORD);
//
//        Map<String, Object> req_ctx = ((BindingProvider)service.getEnterpriseAPISoapPort()).getRequestContext();
//
//        Map<String, List<String>> headers = new HashMap<>();
//        headers.put("Username", Collections.singletonList(USER_NAME));
//        headers.put("Password", Collections.singletonList(PASSWORD));
//        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

    }

    public String ping() {
        String resp = "NOPE, NADA";
        try {
             resp = service.getEnterpriseAPISoapPort().hi();
            log.log(Level.WARNING, "############### PayU web service ping response: " + resp);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed ping", e);
            return "ping FAILED: " + e.getMessage();
        }
        return resp;
    }

    public void payUSetTransaction() {

        AdditionalInfo info = new AdditionalInfo();
        info.setDemoMode("true");
        info.setNotificationUrl("");
        info.setReturnUrl("");
        service.getEnterpriseAPISoapPort().getTransaction(API, SAFE_KEY, info);

        ///////

        //needed in call AdditionalInfo, customer, basket - minimum + custom fields ...
        //TransactionType tt = new TransactionType("");
        Customer cust = new Customer();
        Basket basket = new Basket();
        Fraud fraud = new Fraud();
        List<CreditCard> creditCards = new ArrayList<>();
        List<Eft> efts = new ArrayList<>();
        List<LoyaltyCard> loyaltyCards = new ArrayList<>();
        TransactionRecord transactionRecord = new TransactionRecord();

        SetTransactionResponseMessage mTransactionResponse =
                service.getEnterpriseAPISoapPort().setTransaction(API, SAFE_KEY, null, true,
                        info, cust, basket, fraud, creditCards, efts, loyaltyCards,
                        null, null, null, null, null, null, transactionRecord, null);


    }
}
