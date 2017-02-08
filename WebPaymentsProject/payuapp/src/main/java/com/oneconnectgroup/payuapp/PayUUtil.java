package com.oneconnectgroup.payuapp;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnectgroup.payuapp.payu.PayUResponseDTO;
import com.oneconnectgroup.payuapp.payu.SetTransaction;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;


/**
 * Created by aubreymalabie on 1/29/17.
 */

public class PayUUtil {
    public static final String TAG = PayUUtil.class.getSimpleName();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public interface PayUListener {
        void onResponse(PayUResponseDTO response);

        void onError(String message);
    }

    public static final String GAE_URL = "https://paymentsproject-156208.appspot.com/_ah/api/";
    public static final String CANCEL_URL = GAE_URL + "payUCancel";
    public static final String NOTIFY_URL = GAE_URL + "payUNotify";
    public static final String RETURN_URL = GAE_URL + "payUReturn";
    public static final String NAMESPACE = "http://soap.api.controller.web.payjar.com/";
    public static final String URL = "https://staging.payu.co.za/service/PayUAPI";
    public static final String API = "ONE_ZERO";
    public static final String USER_NAME = "Staging Integration Store 3";
    public static final String PASSWORD = "WSAUFbw6";

    public static final String SAFE_KEY = "{07F70723-1B96-4B97-B891-7BF708594EEA}";
    public static final String PAYMENT_METHODS = "Credit Cards, DiscoveryMiles,Ebucks" +
            "AutoPay, Debit Cards, EFT," +
            "Credit Card Debit Order," +
            "Once Off Payment and Debit Order";

    public static final int SET_TRANS = 1, GET_TRANS = 2;

    public static void setTransaction(SetTransaction transaction, PayUListener listener) {
        new BTask(transaction, listener).execute();
    }

    static class BTask extends AsyncTask<Void, Void, Void> {

        String methodName = "transaction";
        String soapAction;
        int type;
        MySOAPEnvelope soapEnvelope =
                new MySOAPEnvelope(SoapEnvelope.VER10);
        SoapObject request;
        SetTransaction transaction;
        PayUListener listener;
        PayUResponseDTO payUResponse;

        public BTask(SetTransaction transaction, PayUListener listener) {
            this.transaction = transaction;
            this.listener = listener;
            methodName = "setTransaction";

            type = SET_TRANS;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.d(TAG, "doInBackground: ########### talking to PayU ...");

            payUResponse = new PayUResponseDTO();
            soapAction = URL + "/" + methodName;
            try {
                request = new SoapObject(NAMESPACE, methodName);
                //add header and set it to Security
                soapEnvelope.headerOut = new Element[1];
                soapEnvelope.headerOut[0] = buildAuthHeader();
                //add common properties
                transaction.setApi(API);
                transaction.setSafekey(SAFE_KEY);


                switch (type) {
                    case SET_TRANS:
                        PropertyInfo pi = new PropertyInfo();
                        pi.setNamespace("tem");
                        pi.setName("name");
                        pi.setValue("Roel");
                        request.addProperty(pi);

                        request.addProperty("Api", transaction.getApi());
                        request.addProperty("Safekey", transaction.getSafekey());
                        request.addProperty("TransactionType", "PAYMENT");
//                        request.addProperty("AdditionalInformation", transaction.getAdditionalInformation());
//                        request.addProperty("Customer", transaction.getCustomer());
//                        request.addProperty("Basket", transaction.getBasket());
                        break;
                    case GET_TRANS:
                        break;
                }

                Log.w(TAG, "doInBackground: requestname: ".concat(request.getName()) );
                soapEnvelope.setOutputSoapObject(request);

                //make the call
                HttpTransportSE httpTransportSE = new HttpTransportSE(URL);
                httpTransportSE.debug = true;

                httpTransportSE.call(soapAction, soapEnvelope);
                Log.d(TAG, "doInBackground: requestDump:\n" + httpTransportSE.requestDump );
                Log.i(TAG, "doInBackground: response dump:\n" + httpTransportSE.responseDump);
                SoapPrimitive response = (SoapPrimitive) soapEnvelope.getResponse();
                Log.w(TAG, "doInBackground: name returned:".concat(response.getName()));
                Log.e(TAG, "doInBackground: RESPONSE: ".concat(response.toString()));


            } catch (Exception e) {
                Log.e(TAG, "doInBackground: ERROR", e);
                payUResponse.setStatusCode(9);
                payUResponse.setMessage("Unable to process transaction: "
                        .concat(e.getMessage()));
            }
            return null;
        }
        private Element buildAuthHeader() {
            Element securityHeader = new Element().createElement("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
            securityHeader.setAttribute(null, "mustUnderstand","1");

            Element token = new Element().createElement("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "UsernameToken");
             token.setAttribute(null, "Id", "UsernameToken-9");

            Element username = new Element().createElement(null, "Username");
            username.addChild(Node.IGNORABLE_WHITESPACE, USER_NAME);
            token.addChild(Node.ELEMENT, username);

            Element pass = new Element().createElement(null, "Password");
            pass.setAttribute(null, "Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
            pass.addChild(Node.TEXT, PASSWORD);
            token.addChild(Node.ELEMENT, pass);

            securityHeader.addChild(Node.ELEMENT, token);

            return securityHeader;
        }

        private final SoapSerializationEnvelope getSoapSerializationEnvelope(SoapObject request) {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.implicitTypes = true;
            envelope.setAddAdornments(false);
            envelope.setOutputSoapObject(request);


            return envelope;
        }

        @Override
        public void onPostExecute(Void v) {
            Log.i(TAG, "onPostExecute: finito! " + payUResponse.getMessage());
            listener.onResponse(payUResponse);
        }

    }
}





/*

                                                                                             public String getCelsiusConversion(String fValue) {
String data = null;
String methodname = "NewRegistration";

SoapObject request = new SoapObject(NAMESPACE, methodname);
request.addProperty("Title", "");
request.addProperty("FirstName", "");
request.addProperty("LastName", "");

SoapSerializationEnvelope envelope = getSoapSerializationEnvelope(request);

HttpTransportSE ht = getHttpTransportSE();
try {
    ht.call(soapAction + methodname, envelope);
    testHttpResponse(ht);
    SoapPrimitive resultsString = (SoapPrimitive)envelope.getResponse();

    data = resultsString.toString();

} catch (SocketTimeoutException t) {
    t.printStackTrace();
} catch (IOException i) {
    i.printStackTrace();
} catch (Exception q) {
    q.printStackTrace();
}
return data;
    /////////////////////////////////////////////////////////////////////////////////////////
    public static Element buildAuthHeader() {
        Element headers[] = new Element[1];
        headers[0]= new Element().createElement("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
        headers[0].setAttribute(null, "mustUnderstand", "1");
        Element security=headers[0];

        //user token
        Element usernametoken = new Element().createElement(security.getNamespace(), "UsernameToken");
        usernametoken.setAttribute("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Id", "UsernameToken-14CBAE357AC169AFA614664925178422");

        //username
        Element username = new Element().createElement(security.getNamespace(), "Username");
        username.addChild(Node.TEXT, HttpConstant.REQ_HEADER_USERNAME);
        usernametoken.addChild(Node.ELEMENT,username);

        // password
        Element password = new Element().createElement(security.getNamespace(), "Password");
        password.setAttribute(null, "Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
        password.addChild(Node.TEXT, HttpConstant.REQ_HEADER_PASSWORD);
        usernametoken.addChild(Node.ELEMENT,password);


        headers[0].addChild(Node.ELEMENT, usernametoken);

        return headers[0];
    }





SoapSerializationEnvelope sSerialaEnvelop = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        sSerialaEnvelop.dotNet = true;
        sSerialaEnvelop.headerOut = new Element[1];
        sSerialaEnvelop.headerOut[0] = buildAuthHeader(); //// add security request header
        sSerialaEnvelop.bodyOut = sObject;
        sSerialaEnvelop.setOutputSoapObject(sObject);
     */


