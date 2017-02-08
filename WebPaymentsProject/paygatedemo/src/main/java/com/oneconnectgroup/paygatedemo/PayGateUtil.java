package com.oneconnectgroup.paygatedemo;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnect.payments.paymentApi.PaymentApi;
import com.oneconnect.payments.paymentApi.model.PayGateInitiateRequestDTO;
import com.oneconnect.payments.paymentApi.model.PayGateQueryTransactionRequestDTO;
import com.oneconnect.payments.paymentApi.model.PayGateResponseDTO;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Set;
import java.util.Timer;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by aubreymalabie on 1/30/17.
 */

public class PayGateUtil {

    private static PaymentApi paymentApi;
    public static final String TAG = PayGateUtil.class.getSimpleName();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final String GAE_URL = "https://paymentsproject-156208.appspot.com/_ah/api/";
//    public static final String GAE_URL = "http://192.168.1.233:8083/_ah/api/";
    public static final String URL = "https://secure.paygate.co.za/payweb3/",
            QUERY = "query.trans",
            PROCESS_TRANS = "process.trans",
            INITIATE_TRANS = "initiate.trans";


    public static final String
            APPLICATION_NAME = "OneConnect Payments";

    public interface PayGateListener {
        void onResponse(PayGateResponseDTO response);
        void onError(String message);
    }

    public static void initiateTransaction(PayGateInitiateRequestDTO request, PayGateListener listener) {
        new MTask(request, listener).execute();
    }

    public static void queryTransaction(PayGateQueryTransactionRequestDTO request, PayGateListener listener) {
        new MTask(request, listener).execute();
    }

    static class MTask extends AsyncTask<Void, Void, Integer> {

        int type = 0, count = 0;
        Timer timer;
        PayGateInitiateRequestDTO initiateRequest;
        PayGateQueryTransactionRequestDTO queryTransactionRequest;
        PayGateListener listener;
        PayGateResponseDTO response = new PayGateResponseDTO();
        public static final int INITIATE = 1, QUERY = 2;

        public MTask(PayGateInitiateRequestDTO initiateRequest, PayGateListener listener) {
            this.initiateRequest = initiateRequest;
            this.listener = listener;
            type = INITIATE;

        }

        public MTask(PayGateQueryTransactionRequestDTO queryTransactionRequest, PayGateListener listener) {
            this.queryTransactionRequest = queryTransactionRequest;
            this.listener = listener;
            type = QUERY;
        }

        @Override
        protected Integer doInBackground(Void... voids) {

            Log.d(TAG, "PayGateUtil doInBackground: ########################## GAE URL: " + GAE_URL);
            if (paymentApi == null) {  // Only do this once
                PaymentApi.Builder builder = new PaymentApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setApplicationName(APPLICATION_NAME)
                        .setRootUrl(GAE_URL)
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                paymentApi = builder.build();
            }

            try {
                switch (type) {
                    case INITIATE:
                        response = paymentApi.initiatePayGate(initiateRequest).execute();
                        break;
                    case QUERY:
                        response = paymentApi.queryPayGate(queryTransactionRequest).execute();
                        break;
                }
            } catch (ConnectException e) {
                Log.e(TAG, "doInBackground: Server Unavailable", e );
                return 8;
            } catch (Exception e) {
                Log.e(TAG, "doInBackground: failed", e);
                return 9;
            }

            Log.i(TAG, "doInBackground: PayGate api returns from GoogleAppEngine: \n" + GSON.toJson(response));
            return 0;

        }

        @Override
        protected void onPostExecute(Integer result) {
            if (result > 0) {
                if (result == 8) {
                    listener.onError("Payment Service is not available at this time");
                    return;
                }
                listener.onError("Unable to process PayGate transaction");
                return;
            }
            listener.onResponse(response);

        }
    }

    static final OkHttpClient client = new OkHttpClient();

    public static void test(RequestDTO req) {
        new BTask(req).execute();
    }
    static class BTask extends AsyncTask<Void,Void,Integer> {

        RequestDTO request;

        public BTask(RequestDTO request) {
            this.request = request;
        }
        @Override
        protected Integer doInBackground(Void... voids) {

            try {
                sendPOSTRequest(request);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
        }

        public void sendPOSTRequest(RequestDTO req) throws IOException {

            req.calculateChecksum();
            String url = URL.concat(INITIATE_TRANS);
            Log.d(TAG, "sendPOSTRequest: url: ".concat( url));
            Log.d(TAG, "BTask sendPOSTRequest: " + GSON.toJson(req));

            RequestBody body = new FormBody.Builder()
                    .add(PayGateConstants.PAYGATE_ID, PayGateConstants.MERCHANT_PAYGATE_ID)
                    .add(PayGateConstants.REFERENCE, req.getReference())
                    .add(PayGateConstants.AMOUNT, String.valueOf(req.getAmount()))
                    .add(PayGateConstants.COUNTRY, req.getCountry())
                    .add(PayGateConstants.CURRENCY, req.getCurrency())
                    .add(PayGateConstants.EMAIL, req.getEmail())
                    .add(PayGateConstants.LOCALE, req.getLocale())
                    .add(PayGateConstants.RETURN_URL, req.getReturnURL())
                    .add(PayGateConstants.NOTIFY_URL, req.getNotifyURL())
                    .add(PayGateConstants.CHECKSUM, req.getChecksum())
                    .build();

            Request request = new Request.Builder()
                    .addHeader("Content-Type", "text/html")
                    .url(url)
                    .post(body)
                    .build();

            Log.i(TAG, "sendPOSTRequest: print request headers");
            Set<String> namesx =  request.headers().names();
            for (String s: namesx) {
                Log.d(TAG, "sendPOSTRequest: header " + s + " -  " + request.header(s) );
            }

            //make the call
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                Log.i(TAG, "sendPOSTRequest: Request is CONNECTED!!! print response headers");
                Set<String> names =  response.headers().names();
                for (String s: names) {
                    Log.w(TAG, "sendPOSTRequest: header " + s + " -  " + response.header(s) );
                }
            } else {
                Log.e(TAG, "sendPOSTRequest: we are FUCKED!" );
            }

            String data = response.body().string();
            Log.i(TAG, "sendPOSTRequest, response: " + data+ "\n\n");


        }
    }
}
