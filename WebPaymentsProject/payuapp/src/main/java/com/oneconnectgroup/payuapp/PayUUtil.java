package com.oneconnectgroup.payuapp;

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
import com.oneconnect.payments.paymentApi.model.PayUResponseDTO;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by aubreymalabie on 1/29/17.
 */

public class PayUUtil {
    private static PaymentApi paymentApi;
    public static final String TAG = PayUUtil.class.getSimpleName();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public interface PayUListener {
        void onResponse(PayUResponseDTO response);

        void onError(String message);
    }

    public static void ping(PayUListener listener) {
        new MTask(listener).execute();
    }
    public static final int PING = 1, SET_TRANSACTION = 2, GET_TRANSACTION = 3;
    private static class MTask extends AsyncTask<Void, Void, Integer> {

        int count = 0, type = 0;
        Timer timer;
        PayUListener listener;
        PayUResponseDTO response = new PayUResponseDTO();


        public MTask(PayUListener listener) {
            this.listener = listener;
            type = PING;
        }

        @Override
        protected Integer doInBackground(Void... voids) {

            Log.d(TAG, "PayUUtil doInBackground: ##########################: " + Constants.GAE_URL);
            if (paymentApi == null) {  // Only do this once
                PaymentApi.Builder builder = new PaymentApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setApplicationName(Constants.APPLICATION_NAME)
                        .setRootUrl(Constants.GAE_URL)
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                paymentApi = builder.build();
            }

            count = 1;

            switch (type) {
                case PING:
                    pingPayU();
                    break;
                case SET_TRANSACTION:
                    break;
                case GET_TRANSACTION:
                    break;
                default:
                    pingPayU();
                    break;
            }

            return 0;

        }

        @Nullable
        private void pingPayU() {
            Log.w(TAG, "callAPI: *************** call PayU via GAE" );
            try {
                response = paymentApi.pingPayU().execute();
                Log.e(TAG, "doInBackground: api returns from GoogleAppEngine: \n" + GSON.toJson(response));

            } catch (Exception e) {
                Log.e(TAG, "doInBackground: failed to ping PayU", e);
                if (e instanceof SocketTimeoutException) {
                    if (count < 3) {
                        timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                count++;
                                pingPayU();
                            }
                        }, 1000 * count);
                    }
                }
            }
        }
        @Override
        protected void onPostExecute(Integer result) {
            if (result > 0) {
                listener.onError("Unable to process PayU transaction");
                return;
            }
            listener.onResponse(response);

        }
    }
}
