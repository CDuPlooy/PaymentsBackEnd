package com.oneconnect.payments.backend.util;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by aubreymalabie on 1/19/17.
 */

public class PayGateAPI {

    public static final String INITIATE_TRANSACTION_URL = "https://secure.paygate.co.za/payweb3/initiate.trans";
    private static final Logger log = Logger.getLogger(PayGateAPI.class.getName());

    public static final Gson gson = new Gson();
    public static final String CONTENT_TYPE = "application/json; charset=UTF-8";

    public TransactionResponseDTO initiateTransaction(InitiateTransactionDTO dto) {
        URLFetchService url_service = URLFetchServiceFactory.getURLFetchService();
        HTTPRequest request = null;
        TransactionResponseDTO resp = new TransactionResponseDTO();
        try {
            request = new HTTPRequest(new URL(INITIATE_TRANSACTION_URL), HTTPMethod.POST);
            request.setPayload(gson.toJson(dto).getBytes("utf8"));

            HTTPResponse response = url_service.fetch(request);
            if (response.getResponseCode() != 200) {
                throw new IOException(new String(response.getContent()));
            }
            String content = new String(response.getContent());
            log.log(Level.WARNING,content);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }
}
