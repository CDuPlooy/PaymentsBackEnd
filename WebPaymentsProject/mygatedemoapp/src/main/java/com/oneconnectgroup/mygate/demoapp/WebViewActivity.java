package com.oneconnectgroup.mygate.demoapp;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.oneconnectgroup.mygate.demoapp.MyGateUtil.FAILED_URL;
import static com.oneconnectgroup.mygate.demoapp.MyGateUtil.MERCHANT_ID;
import static com.oneconnectgroup.mygate.demoapp.MyGateUtil.MYGATE_URL;
import static com.oneconnectgroup.mygate.demoapp.MyGateUtil.SUCCESS_URL;
import static com.oneconnectgroup.mygate.demoapp.MyGateUtil.TAG;

public class WebViewActivity extends AppCompatActivity {

    String html;
    Toolbar toolbar;
    FloatingActionButton fab;
    WebView webView;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        html = getIntent().getStringExtra("html");
        webView = (WebView) findViewById(R.id.webView);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToPaymentPage();
            }
        });
        //show();
    }
    private void redirectToPaymentPage() {
        showSnackBar("Redirecting to MyGate", "OK","yellow");
        StringBuilder sb = new StringBuilder();
        sb.append("mode=").append("0");
        sb.append("&_PAGE=").append("M28Z8Q%2CU%2C%209%28X%3EAS%2CYXA%2CAQC%3D%2CF%28%2C%24G5%3C%5D%27%2BR%5DO%3CE%26GG%3DG%3BV4CQ9%5BPG8Q%28%3C%2C1%0AMHJRD%3ED0%3CUCHS%3A%21H%2F2VT%2C%29%2CI6C%5D%201%3A%20U%3EL%5C%40%2C%3A%28%24%2D%23%5CG%20%23UES%5CK%3C%5D%22ZH4%25%3B%20%5E%0A%26%28JV%2FJG%3D5%0A");
        sb.append("&_PAGE_KEY=").append("tjs7pM26LIw%3D");
        sb.append("&jscriptEnabled=").append("1");
        sb.append("&cboCardType=").append("0");


        try {
            String encoded = URLEncoder.encode(sb.toString(), "UTF-8");
            Log.w(TAG, "redirectToPaymentPage: ".concat(sb.toString()));

            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());
            webView.postUrl("https://virtual.mygateglobal.com/PaymentPage.cfm", sb.toString().getBytes());
            //webView.loadData(html,"html/text","utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
    private void startWebView() {

    }
    private void showSnackBar(String title, String action, String color) {
        snackbar = Snackbar.make(toolbar, title, Snackbar.LENGTH_INDEFINITE);
        snackbar.setActionTextColor(Color.parseColor(color));
        if (action != null) {
            snackbar.setAction(action, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snackbar.dismiss();
                }
            });
        }
        snackbar.show();
    }

    private void show() {
        webView.loadData(html, "text/html", "UTF-8");
    }


    public static void test(MyGateRequestDTO req) {
        new BTask(req).execute();
    }
    static class BTask extends AsyncTask<Void,Void,Integer> {
        OkHttpClient client = new OkHttpClient();
        MyGateRequestDTO myGateRequest;

        public BTask(MyGateRequestDTO request) {
            this.myGateRequest = request;
        }
        @Override
        protected Integer doInBackground(Void... voids) {

            MyGateResponseDTO resp = new MyGateResponseDTO();
            myGateRequest.setApplicationID(myGateRequest.getApplicationID());
            myGateRequest.setMerchantID(MERCHANT_ID);
            myGateRequest.setRedirectFailureURL(FAILED_URL);
            myGateRequest.setRedirectSuccessfulURL(SUCCESS_URL);


            RequestBody formBody = new FormBody.Builder()
                    .add(MyGateRequestDTO.PARAM_APPLICATION_ID, myGateRequest.getApplicationID())
                    .add(MyGateRequestDTO.PARAM_MERCHANT_ID,myGateRequest.getMerchantID())
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
                Response okResponse = client.newCall(request).execute();
                String content = new String(okResponse.body().string());
                Log.e(TAG, ".........response from MyGate, content:  " + content);
                resp.setHtml(content);
                resp.setMessage("response from MyGate");

            } catch (Exception ex) {
                Log.e(TAG,  "*** MyGate server problem ...: ", ex);
                resp.setStatusCode(8);
                resp.setMessage("Bad response from myGate: " + ex.getMessage());
            }

            return 0;
        }


    }
}
