package com.oneconnectgroup.webpayments.app.api;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.oneconnect.payemts.backend.paymentApi.PaymentApi;
import com.oneconnect.payemts.backend.paymentApi.model.InitiateTransactionDTO;
import com.oneconnect.payemts.backend.paymentApi.model.TransactionResponseDTO;

import java.io.IOException;

/**
 * Created by aubreymalabie on 1/20/17.
 */

public class PayGateUtil {
    public static final String TAG = PayGateUtil.class.getSimpleName(),
    APPLICATION_NAME = "oneConnectPayments";
    private static PaymentApi paymentApi = null;
//    public static final String APP_ENGINE_ROOT_URL = "https://paymentsproject-156208.appspot.com/_ah/api";
    public static final String APP_ENGINE_ROOT_URL = "http://192.168.1.233:8083/_ah/api/";

    public static void startTransaction(InitiateTransactionDTO dto, PaymentListener listener) {
       // dto.setc
        new InitiateTransaction(dto,listener).execute();
    }

    public interface PaymentListener {
        void onResponse(TransactionResponseDTO response);
        void onError(String message);
    }
    static class InitiateTransaction extends AsyncTask<Void, Void, TransactionResponseDTO> {

        InitiateTransactionDTO initTransaction;
        PaymentListener listener;

        public InitiateTransaction(InitiateTransactionDTO initTransaction, PaymentListener listener) {
            this.initTransaction = initTransaction;
            this.listener = listener;
        }

        @Override
        protected TransactionResponseDTO doInBackground(Void... params) {
            Log.d(TAG, "doInBackground: ###################################################");
            if (paymentApi == null) {  // Only do this once
                PaymentApi.Builder builder = new PaymentApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setApplicationName(APPLICATION_NAME)
                        .setRootUrl(APP_ENGINE_ROOT_URL)
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                paymentApi = builder.build();
            }

            try {
                TransactionResponseDTO resp = paymentApi.initiatePayGateTransaction(initTransaction).execute();
                Log.e(TAG, "doInBackground: com.oneconnectgroup.webpayments.app.api returns from GoogleAppEngine: " + resp.getMessage());
                return resp;
            } catch (IOException e) {
                Log.e(TAG, "doInBackground: failed to initiate Transaction in gae", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(TransactionResponseDTO result) {
            if (result == null) {
                listener.onError("Unable to failed to initiate");
                return;
            }
            listener.onResponse(result);
        }
    }

}
