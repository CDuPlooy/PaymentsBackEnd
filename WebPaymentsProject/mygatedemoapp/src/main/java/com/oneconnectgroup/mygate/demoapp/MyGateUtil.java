package com.oneconnectgroup.mygate.demoapp;

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

import java.io.IOException;
import java.util.Timer;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by aubreymalabie on 1/23/17.
 */

public class MyGateUtil {

    private static PaymentApi paymentApi;
    public static final String TAG = MyGateUtil.class.getSimpleName();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final String
            URL = "https://paymentsproject-156208/appspot.com/_ah/api/",
            SUCCESS_URL = URL + "mygate-success",
            FAILED_URL = URL + "mygate-failure",
            MERCHANT_ID = "F5785ECF-1EAE-40A0-9D37-93E2E8A4BAB3",
            APPLICATION_ID = "3C5F80CB-F2DA-45D3-800D-A876E6258F17",
            MYGATE_URL = "https://virtual.mygateglobal.com/PaymentPage.cfm";
    public static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public interface MyGateListener {
        void onResponse(MyGateResponseDTO response);

        void onError(String message);
    }

    public static void startRequest(MyGateRequestDTO request, MyGateListener listener) {
           new MTask(request,listener).execute();
    }

    static class MTask extends AsyncTask<Void, Void, Integer> {

        int count = 0;
        Timer timer;
        MyGateRequestDTO request;
        MyGateListener listener;
        MyGateResponseDTO response = new MyGateResponseDTO();
        OkHttpClient okHttpClient = new OkHttpClient();

        public MTask(MyGateRequestDTO request, MyGateListener listener) {
            this.request = request;
            this.listener = listener;
        }

        @Override
        protected Integer doInBackground(Void... voids) {

            Log.d(TAG, "MyGateUtil doInBackground: ##########################: " + Constants.GAE_URL);
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

            startRequest(request);
            if (response == null) {
                return 9;
            }
            return 0;

        }

        @Nullable
        private void callAPI() {
//            Log.w(TAG, "callAPI: *************** call MyGate via GAE" );
//            try {
//                response = paymentApi.startRequest(request).execute();
//                Log.e(TAG, "doInBackground: api returns from GoogleAppEngine: \n" + GSON.toJson(response));
//
//            } catch (Exception e) {
//                Log.e(TAG, "doInBackground: failed to transact", e);
//                if (e instanceof SocketTimeoutException) {
//                    if (count < 3) {
//                        timer = new Timer();
//                        timer.schedule(new TimerTask() {
//                            @Override
//                            public void run() {
//                                count++;
//                                callAPI();
//                            }
//                        }, 1000 * count);
//                    }
//                }
//            }
        }
        public void startRequest(MyGateRequestDTO myGateRequest) {
            Log.d(TAG,"starting MyGate request processing");
            myGateRequest.setApplicationID(APPLICATION_ID);
            myGateRequest.setMerchantID(MERCHANT_ID);
            myGateRequest.setRedirectFailureURL(FAILED_URL);
            myGateRequest.setRedirectSuccessfulURL(SUCCESS_URL);

            String json = GSON.toJson(myGateRequest);

            RequestBody formBody = new FormBody.Builder()
                    .add(MyGateRequestDTO.PARAM_APPLICATION_ID, APPLICATION_ID)
                    .add(MyGateRequestDTO.PARAM_MERCHANT_ID,MERCHANT_ID)
                    .add(MyGateRequestDTO.PARAM_MODE,String.valueOf(myGateRequest.getMode()))
                    .add(MyGateRequestDTO.PARAM_CURRENCY_CODE,myGateRequest.getTxtCurrencyCode())
                    .add(MyGateRequestDTO.PARAM_AMOUNT,String.valueOf(myGateRequest.getAmount()))
                    .add(MyGateRequestDTO.PARAM_REDIRECT_SUCCESS_URL,SUCCESS_URL)
                    .add(MyGateRequestDTO.PARAM_REDIRECT_FAILED_URL,FAILED_URL)
                    .build();
            Request request = new Request.Builder()
                    .url(MYGATE_URL)
                    .post(formBody)
                    .build();

            try {
                Response okResponse = okHttpClient.newCall(request).execute();

                String content = new String(okResponse.body().string());
                Log.i(TAG, ".........response from MyGate, content:  " + content);
                response.setHtml(content);
                response.setMessage("HTML from MyGate");

            } catch (Exception ex) {
                Log.i(TAG, "*** MyGate server problem ...: ", ex);
                response.setStatusCode(8);
                response.setMessage("Bad response from myGate: " + ex.getMessage());
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
