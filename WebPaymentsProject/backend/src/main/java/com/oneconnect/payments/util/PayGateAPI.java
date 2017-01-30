package com.oneconnect.payments.util;

import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.GsonBuilder;
import com.oneconnect.payments.paygate.PayGateInitiateRequestDTO;
import com.oneconnect.payments.paygate.PayGateInitiateTranResponseDTO;
import com.oneconnect.payments.paygate.PayGateNotifyResponseDTO;
import com.oneconnect.payments.paygate.PayGateQueryTransactionRequestDTO;

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

    private static final Logger log = Logger.getLogger(PayGateAPI.class.getName());
    static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static final String URL = "https://secure.paygate.co.za/payweb3/",
            QUERY = "query.trans",
            PROCESS_TRANS = "process.trans",
            INITIATE_TRANS = "initiate.trans";


    public PayGateInitiateTranResponseDTO initiateTransaction(PayGateInitiateRequestDTO payGateRequest) {
        PayGateInitiateTranResponseDTO resp = new PayGateInitiateTranResponseDTO();
        //todo URLFetch here and do POST
        String url = URL.concat(INITIATE_TRANS);
        String json = GSON.toJson(payGateRequest);
        URLFetchService url_service = URLFetchServiceFactory.getURLFetchService();
        try {
            URL myURL = new URL(url);
            HTTPRequest request = new HTTPRequest(myURL, HTTPMethod.POST);
            request.setHeader(new HTTPHeader("Content-Type", "application/json; charset=UTF-8"));

            request.setPayload(json.getBytes("utf8"));
            HTTPResponse response = url_service.fetch(request);
            if (response.getResponseCode() != 200) {
                throw new IOException(new String(response.getContent()));
            }
            String content = new String(response.getContent());
           log.log(Level.WARNING,"initiateTransaction response: ".concat(content));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        log.log(Level.WARNING, GSON.toJson(resp));
        return resp;
    }
    public PayGateNotifyResponseDTO getTransactionResponse(PayGateQueryTransactionRequestDTO payGateRequest) {
        PayGateNotifyResponseDTO resp = new PayGateNotifyResponseDTO();
        //todo URLFetch here and do POST
        String url = URL.concat(QUERY);
        String json = GSON.toJson(payGateRequest);
        URLFetchService url_service = URLFetchServiceFactory.getURLFetchService();
        try {
            URL myURL = new URL(url);
            HTTPRequest request = new HTTPRequest(myURL, HTTPMethod.POST);
            request.setHeader(new HTTPHeader("Content-Type", "application/json; charset=UTF-8"));

            request.setPayload(json.getBytes("utf8"));
            HTTPResponse response = url_service.fetch(request);
            if (response.getResponseCode() != 200) {
                throw new IOException(new String(response.getContent()));
            }
            String content = new String(response.getContent());
            log.log(Level.WARNING,"getTransactionResponse response: ".concat(content));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        log.log(Level.WARNING, GSON.toJson(resp));
        return resp;
    }

}
