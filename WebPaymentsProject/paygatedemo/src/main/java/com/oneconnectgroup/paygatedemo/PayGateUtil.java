package com.oneconnectgroup.paygatedemo;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnect.payments.paymentApi.PaymentApi;
import com.oneconnect.payments.paymentApi.model.PayGateInitiateRequestDTO;
import com.oneconnect.payments.paymentApi.model.PayGateResponseDTO;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by aubreymalabie on 1/30/17.
 */

public class PayGateUtil {

    private static PaymentApi paymentApi;
    public static final String TAG = PayGateUtil.class.getSimpleName();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final String GAE_URL = "https://paymentsproject-156208.appspot.com/_ah/api/";
//    public static final String GAE_URL = "http://192.168.1.233:8083/_ah/api/";

    public static final String
            APPLICATION_NAME = "OneConnect Payments";

     public interface PayGateListener {
         void onResponse(PayGateResponseDTO response);
         void onError(String message);
     }

    public static void initiateTransaction(PayGateInitiateRequestDTO request, PayGateListener listener) {
        new MTask(request,listener).execute();
    }
    static class MTask extends AsyncTask<Void, Void, Integer> {

        int count = 0;
        Timer timer;
        PayGateInitiateRequestDTO request;
        PayGateListener listener;
        PayGateResponseDTO response = new PayGateResponseDTO();

        public MTask(PayGateInitiateRequestDTO request, PayGateListener listener) {
            this.request = request;
            this.listener = listener;
        }

        @Override
        protected Integer doInBackground(Void... voids) {

            Log.d(TAG, "MasterPassUtil doInBackground: ##########################: " + GAE_URL);
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

            count = 1;

            callAPI();
            if (response == null) {
                return 9;
            }
            return 0;

        }

        @Nullable
        private void callAPI() {
            Log.w(TAG, "callAPI: *************** call PayGate via GAE" );
            try {
                response = paymentApi.initiatePayGate(request).execute();
                Log.e(TAG, "doInBackground: api returns from GoogleAppEngine: \n" + GSON.toJson(response));

            } catch (Exception e) {
                Log.e(TAG, "doInBackground: failed to get code", e);
                if (e instanceof SocketTimeoutException) {
                    if (count < 3) {
                        timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                count++;
                                callAPI();
                            }
                        }, 1000 * count);
                    }
                }
            }
        }
        @Override
        protected void onPostExecute(Integer result) {
            if (result > 0) {
                listener.onError("Unable to process transaction request");
                return;
            }
            listener.onResponse(response);

        }
    }
}
