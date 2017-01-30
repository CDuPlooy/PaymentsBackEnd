package com.oneconnectgroup.webpayments.app.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnect.payments.paymentApi.PaymentApi;
import com.oneconnect.payments.

/**
 * Created by aubreymalabie on 1/20/17.
 */

public class PayGateUtil {
    public static final String TAG = PayGateUtil.class.getSimpleName(),
    APPLICATION_NAME = "oneConnectPayments";
    private static PaymentApi paymentApi = null;
    public static final String APP_ENGINE_ROOT_URL = "https://paymentsproject-156208.appspot.com/_ah/api";
//    public static final String APP_ENGINE_ROOT_URL = "http://192.168.1.233:8083/_ah/api/";

//    public static void paymentRequest(payga dto, PaymentListener listener) {
//       // dto.setc
//      //  new InitiateTransaction(dto,listener).execute();
//    }

    public interface PaymentListener {
        void onResponse(payg response);
        void onError(String message);
    }
//    static class InitiateTransaction extends AsyncTask<Void, Void, SinglePaymentResponse> {
//
//        payg singlePaymentRequest;
//        PaymentListener listener;
//
//        public InitiateTransaction(SinglePaymentRequest singlePaymentRequest, PaymentListener listener) {
//            this.singlePaymentRequest = singlePaymentRequest;
//            this.listener = listener;
//        }
//
//        @Override
//        protected SinglePaymentResponse doInBackground(Void... params) {
//            Log.d(TAG, "doInBackground: ###################################################");
//            if (paymentApi == null) {  // Only do this once
//                PaymentApi.Builder builder = new PaymentApi.Builder(AndroidHttp.newCompatibleTransport(),
//                        new AndroidJsonFactory(), null)
//                        .setApplicationName(APPLICATION_NAME)
//                        .setRootUrl(APP_ENGINE_ROOT_URL)
//                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                            @Override
//                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                                abstractGoogleClientRequest.setDisableGZipContent(true);
//                            }
//                        });
//                paymentApi = builder.build();
//            }
//
////            try {
////                SinglePaymentResponse resp = paymentApi.singlePaymentRequest(singlePaymentRequest).execute();
////                Log.e(TAG, "doInBackground: singlePaymentRequest returns from GoogleAppEngine: \n"
////                + GSON.toJson(resp.getCardPaymentResponse()));
////                return resp;
////            } catch (IOException e) {
////                Log.e(TAG, "singlePaymentRequest, doInBackground: failed in Google App Engine:\n" + e.getMessage());
////                return null;
////            }
//        }
//
//        @Override
//        protected void onPostExecute(SinglePaymentResponse result) {
//            if (result == null) {
//                listener.onError("Unable to failed to initiate");
//                return;
//            }
//            listener.onResponse(result);
//        }
//    }

//    static class PingTask extends AsyncTask<Void, Void, PingResponse> {
//
//        PaymentApi.SinglePaymentRequest singlePaymentRequest;
//        PaymentListener listener;
//
//        public InitiateTransaction(SinglePaymentRequest singlePaymentRequest, PaymentListener listener) {
//            this.singlePaymentRequest = singlePaymentRequest;
//            this.listener = listener;
//        }
//
//        @Override
//        protected SinglePaymentResponse doInBackground(Void... params) {
//            Log.d(TAG, "doInBackground: ###################################################");
//            if (paymentApi == null) {  // Only do this once
//                PaymentApi.Builder builder = new PaymentApi.Builder(AndroidHttp.newCompatibleTransport(),
//                        new AndroidJsonFactory(), null)
//                        .setApplicationName(APPLICATION_NAME)
//                        .setRootUrl(APP_ENGINE_ROOT_URL)
//                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                            @Override
//                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                                abstractGoogleClientRequest.setDisableGZipContent(true);
//                            }
//                        });
//                paymentApi = builder.build();
//            }
//
//            try {
//                SinglePaymentResponse resp = paymentApi.singlePaymentRequest(singlePaymentRequest).execute();
//                Log.e(TAG, "doInBackground: singlePaymentRequest returns from GoogleAppEngine: \n"
//                        + GSON.toJson(resp.getCardPaymentResponse()));
//                return resp;
//            } catch (IOException e) {
//                Log.e(TAG, "singlePaymentRequest, doInBackground: failed in Google App Engine:\n" + e.getMessage());
//                return null;
//            }
//        }
//
//        @Override
//        protected void onPostExecute(SinglePaymentResponse result) {
//            if (result == null) {
//                listener.onError("Unable to failed to initiate");
//                return;
//            }
//            listener.onResponse(result);
//        }
//    }

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
}
