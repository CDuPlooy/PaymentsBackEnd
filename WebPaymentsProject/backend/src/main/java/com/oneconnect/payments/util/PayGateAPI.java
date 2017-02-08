package com.oneconnect.payments.util;

import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
        log.log(Level.WARNING, "initiateTransaction: ".concat(GSON.toJson(payGateRequest)));
        PayGateInitiateTranResponseDTO resp = new PayGateInitiateTranResponseDTO();

        payGateRequest.calculateChecksum();
        RequestBody formBody = new FormBody.Builder()
                .add(PayGateInitiateRequestDTO.PARM_PAYGATE_ID, payGateRequest.getPayGateID())
                .add(PayGateInitiateRequestDTO.PARM_REFERENCE, payGateRequest.getReference())
                .add(PayGateInitiateRequestDTO.PARM_AMOUNT, String.valueOf(payGateRequest.getAmount()))
                .add(PayGateInitiateRequestDTO.PARM_CURRENCY, payGateRequest.getCurrency())
                .add(PayGateInitiateRequestDTO.PARM_RETURN_URL, payGateRequest.getReturnURL())
                .add(PayGateInitiateRequestDTO.PARM_TRANSACTION_DATE, payGateRequest.getTransactionDate())
                .add(PayGateInitiateRequestDTO.PARM_LOCALE, payGateRequest.getLocale())
                .add(PayGateInitiateRequestDTO.PARM_COUNTRY, payGateRequest.getCountry())
                .add(PayGateInitiateRequestDTO.PARM_EMAIL, payGateRequest.getEmail())
                .add(PayGateInitiateRequestDTO.PARM_NOTIFY_URL, payGateRequest.getNotifyURL())
                .add(PayGateInitiateRequestDTO.PARM_USER1, payGateRequest.getUser1())
                .add(PayGateInitiateRequestDTO.PARM_CHECKSUM, payGateRequest.getChecksum())
                .build();
        log.log(Level.WARNING,formBody.toString());
        Request request = new Request.Builder()
                .url(URL.concat(INITIATE_TRANS))
                .post(formBody)
                .build();

        try {
            log.log(Level.WARNING, GSON.toJson(payGateRequest));
            GoogleAppEngineCall call = new GoogleAppEngineCall(request);
            Response okResponse = call.execute();
            String content = new String(okResponse.body().string());
            String[] parms = content.split("&");
            String paygateIDphrase = parms[0];
            String requestIDPhrase = parms[1];
            String refPhrase = parms[2];
            String checksumPhrase = parms[3];

            String[] rr = requestIDPhrase.split("=");
            String requestID = rr[1];

            String[] refs = refPhrase.split("=");
            String reference = refs[1];

            String[] cks = checksumPhrase.split("=");
            String checksum = cks[1];

            log.log(Level.WARNING, "...response from PayGate\n ref:  " + reference
                    + "\nrequestID: " + requestID + "\nchecksum: " + checksum);
            //todo - build incoming checksum value and compare
//            if (checksum.equalsIgnoreCase(payGateRequest.getChecksum())) {
            log.log(Level.WARNING, "checksum matches checksum from PayGate");
            resp.setMessage("PayGate request processed OK");
            resp.setPayGateID(payGateRequest.getPayGateID());
            resp.setPayRequestID(requestID);
            resp.setReference(reference);

//            }

        } catch (Exception ex) {
            log.log(Level.SEVERE, "*** PayGate server problem ...: ", ex);
            resp.setStatusCode(8);
            resp.setMessage("Bad response from PayGate: " + ex.getMessage());
        }
        log.log(Level.WARNING, "PAYGATE RESPONSE: ".concat(GSON.toJson(resp)));
        return resp;
    }


    public PayGateNotifyResponseDTO getTransactionResponse(PayGateQueryTransactionRequestDTO payGateRequest) {
        PayGateNotifyResponseDTO resp = new PayGateNotifyResponseDTO();
        payGateRequest.calculateChecksum();
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
            log.log(Level.WARNING, "getTransactionResponse response: ".concat(content));
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
