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
            API_LIBLITE_TOKEN = "86807EDF15FAB8D56490871A5AD5E664";



    public MasterPassResponseDTO queryCode(String code) {
        String url = URL + "/code/" + code;
        log.log(Level.WARNING,"MasterPass Get Code request starting ...\n" + url);

        URLFetchService urlFetchService = URLFetchServiceFactory.getURLFetchService();
        HTTPRequest request = null;
        MasterPassResponseDTO resp = new MasterPassResponseDTO();
        try {
            request = new HTTPRequest(new URL(url), HTTPMethod.GET);
            request.setHeader(new HTTPHeader("Content-Type", CONTENT_TYPE));
            HTTPResponse response = urlFetchService.fetch(request);
            if (response.getResponseCode() != 200) {
                log.log(Level.SEVERE, "ERROR: HTTP response code from MasterPass is: "
                        + response.getResponseCode()
                        + " " + response.getContent().toString());
                resp.setStatusCode(response.getResponseCode());
                resp.setMessage("Unable to get transcation code");
                return resp;
            }

            String content = new String(response.getContent());
            log.log(Level.WARNING, ".........response from MasterPass, content:  " + content);
            CodeQueryResponseDTO crd = gson.fromJson(content,CodeQueryResponseDTO.class);
            resp.setCodeQueryResponse(crd);
            resp.setMessage("Transaction code successfully queried");

        } catch (Exception e) {
            log.log(Level.SEVERE,"MasterPass Query Code failed", e);
            resp.setStatusCode(9);
            resp.setMessage("Failed to query MasterPass transaction code");
        }
        return resp;
    }




    //Authorization:  user  fred:mypassword
    public MasterPassResponseDTO getCode(MasterPassRequestDTO mpr) {
        String url = URL + "/code/create";
        log.log(Level.WARNING,"MasterPass Get Code request starting ...\n" + url);
        // test();

        String json = gson.toJson(mpr);
        URLFetchService urlFetchService = URLFetchServiceFactory.getURLFetchService();
        HTTPRequest request;
        MasterPassResponseDTO resp = new MasterPassResponseDTO();
        try {
            request = new HTTPRequest(new URL(url), HTTPMethod.POST);
            request.setHeader(new HTTPHeader("Content-Type", CONTENT_TYPE));
            String userP = API_USER_NAME+":"+API_PASSWORD;
            String authorizationString = "Basic " + Base64.encodeBase64String(userP.getBytes());

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

        } catch (Exception e) {
            log.log(Level.SEVERE,"MasterPass Get Code failed", e);
            resp.setStatusCode(9);
            resp.setMessage("Failed to get MasterPass transaction code");
        }
        return resp;
    }
}
