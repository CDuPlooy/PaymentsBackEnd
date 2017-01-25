package com.oneconnect.payments.util;

import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnect.payments.masterpass.CodeQueryResponseDTO;
import com.oneconnect.payments.masterpass.CodeResponseDTO;
import com.oneconnect.payments.masterpass.MasterPassRequestDTO;
import com.oneconnect.payments.masterpass.MasterPassResponseDTO;
import com.oneconnect.payments.masterpass.NetworkPurchaseDTO;
import com.oneconnect.payments.masterpass.NetworkPurchaseResponseDTO;

import org.apache.commons.codec.binary.Base64;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by aubreymalabie on 1/23/17.
 */


public class MasterPassAPI {

    public static final String URL = "https://masterpasstest.oltio.co.za/pluto";         //TEST
    //    public static final String URL = "https://masterpass.oltio.co.za/rags";            //PRODUCTION
    static final Logger log = Logger.getLogger(MasterPassAPI.class.getSimpleName());
    public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static final String CONTENT_TYPE = "application/json; charset=UTF-8",
    API_USER_NAME = "merchant-379", API_PASSWORD = "ABFC4C87DE2319CC7FAB910DD654645D",
    AUTH_STRING = API_USER_NAME+":"+API_PASSWORD;


    public NetworkPurchaseResponseDTO makeNetworkPurchase(NetworkPurchaseDTO networkPurchase) {
        String url = URL + "/purchase/network/" + networkPurchase.getNetwork();
        log.log(Level.WARNING,"MasterPass getCode request starting ...\n" + url);

        String json = gson.toJson(networkPurchase);
        URLFetchService urlFetchService = URLFetchServiceFactory.getURLFetchService();
        HTTPRequest request;
        NetworkPurchaseResponseDTO resp = new NetworkPurchaseResponseDTO();
        try {
            request = new HTTPRequest(new URL(url), HTTPMethod.POST);
            request.setHeader(new HTTPHeader("Content-Type", CONTENT_TYPE));
            String authorizationString = "Basic " + Base64.encodeBase64String(AUTH_STRING.getBytes());

            request.addHeader(new HTTPHeader("Authorization", authorizationString));
            request.setPayload(json.getBytes("UTF-8"));
            HTTPResponse response = urlFetchService.fetch(request);
            if (response.getResponseCode() != 200) {
                switch (response.getResponseCode()) {
                    case 432:          //invalid amt
                        break;
                    case 433:          //invalid network
                        break;
                    case 434:          //client suspended
                        break;
                    case 512:          //general system error
                        break;
                }
                log.log(Level.SEVERE, "ERROR: HTTP response code from MasterPass is: " + response.getResponseCode()
                        + " " + response.getContent().toString());
                resp.setStatusCode(response.getResponseCode());
                resp.setMessage("Unable to get MasterPass transaction code");

                return resp;
            }
            String content = new String(response.getContent());

            resp = gson.fromJson(content,NetworkPurchaseResponseDTO.class);
            resp.setStatusCode(0);
            resp.setMessage("MasterPass Network purchase  successfully completed");
            log.log(Level.WARNING, ".........response from MasterPass, NetworkPurchaseResponseDTO:  " + gson.toJson(resp));


        } catch (Exception e) {
            log.log(Level.SEVERE,"MasterPass Network Purchase failed", e);
            resp.setStatusCode(9);
            resp.setMessage("Failed to process MasterPass network purchase");
        }
        return resp;
    }
    /**
     * Get transaction information from masterpass by code
     * @param code
     * @return
     */
    public MasterPassResponseDTO queryCode(String code) {
        String url = URL + "/code/" + code;
        log.log(Level.WARNING,"MasterPass queryCode request starting ...\n" + url);

        URLFetchService urlFetchService = URLFetchServiceFactory.getURLFetchService();
        HTTPRequest request = null;
        MasterPassResponseDTO resp = new MasterPassResponseDTO();
        try {
            request = new HTTPRequest(new URL(url), HTTPMethod.GET);
            request.setHeader(new HTTPHeader("Content-Type", CONTENT_TYPE));
            String authorizationString = "Basic " + Base64.encodeBase64String(AUTH_STRING.getBytes());
            request.addHeader(new HTTPHeader("Authorization", authorizationString));
            HTTPResponse response = urlFetchService.fetch(request);
            if (response.getResponseCode() != 200) {
                log.log(Level.SEVERE, "ERROR: HTTP response code from MasterPass is: "
                        + response.getResponseCode()
                        + " " + response.getContent().toString());
                resp.setStatusCode(response.getResponseCode());
                resp.setMessage("Unable to query transcation code");
                return resp;
            }

            String content = new String(response.getContent());

            CodeQueryResponseDTO crd = gson.fromJson(content,CodeQueryResponseDTO.class);
            resp.setCodeQueryResponse(crd);
            resp.setMessage("Transaction code successfully queried");
            log.log(Level.WARNING, ".........response from MasterPass, CodeQueryResponseDTO:  " + gson.toJson(crd));

        } catch (Exception e) {
            log.log(Level.SEVERE,"MasterPass Query Code failed", e);
            resp.setStatusCode(9);
            resp.setMessage("Failed to query MasterPass transaction code");
        }
        return resp;
    }

    /**
     * Request a transaction code from masterpass
     * @param mpr
     * @return
     */
    public MasterPassResponseDTO getCode(MasterPassRequestDTO mpr) {
        String url = URL + "/code/create";
        log.log(Level.WARNING,"MasterPass getCode request starting ...\n" + url);

        String json = gson.toJson(mpr);
        URLFetchService urlFetchService = URLFetchServiceFactory.getURLFetchService();
        HTTPRequest request;
        MasterPassResponseDTO resp = new MasterPassResponseDTO();
        try {
            request = new HTTPRequest(new URL(url), HTTPMethod.POST);
            request.setHeader(new HTTPHeader("Content-Type", CONTENT_TYPE));
            String authorizationString = "Basic " + Base64.encodeBase64String(AUTH_STRING.getBytes());

            request.addHeader(new HTTPHeader("Authorization", authorizationString));
            request.setPayload(json.getBytes("UTF-8"));
            HTTPResponse response = urlFetchService.fetch(request);
            if (response.getResponseCode() != 200) {
                log.log(Level.SEVERE, "ERROR: HTTP response code from MasterPass is: " + response.getResponseCode()
                        + " " + response.getContent().toString());
                resp.setStatusCode(response.getResponseCode());
                resp.setMessage("Unable to get MasterPass transaction code");

                return resp;
            }
            String content = new String(response.getContent());

            CodeResponseDTO crd = gson.fromJson(content,CodeResponseDTO.class);
            resp.setCodeResponse(crd);
            resp.setMessage("MasterPass Transaction code successfully obtained");
            log.log(Level.WARNING, ".........response from MasterPass, CodeResponseDTO:  " + gson.toJson(crd));

            //todo remove this <code></code>
            queryCode(crd.getCode());

        } catch (Exception e) {
            log.log(Level.SEVERE,"MasterPass Get Code failed", e);
            resp.setStatusCode(9);
            resp.setMessage("Failed to get MasterPass transaction code");
        }
        return resp;
    }
}
