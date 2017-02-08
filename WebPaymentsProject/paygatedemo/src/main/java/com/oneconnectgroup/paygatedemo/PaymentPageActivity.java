package com.oneconnectgroup.paygatedemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.apache.http.util.EncodingUtils;

import java.security.NoSuchAlgorithmException;

public class PaymentPageActivity extends AppCompatActivity {

    String requestID, reference, checksum;
    WebView webView;
    FloatingActionButton fab;
    Toolbar toolbar;


    public static final String TAG = PaymentPageActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Payment");
        getSupportActionBar().setSubtitle("OneConnect Gateway");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        requestID = getIntent().getStringExtra("requestID");
        reference = getIntent().getStringExtra("reference");

        webView = (WebView) findViewById(R.id.webView);
        startRedirect();
    }

    private void startRedirect() {
        StringBuilder sb = new StringBuilder();
        sb.append(PayGateConstants.MERCHANT_PAYGATE_ID);
        sb.append(requestID);
        sb.append(reference).append(PayGateConstants.ENCRYPTION_KEY);

        try {
            checksum = ChecksumUtil.getMD5Checksum(sb.toString());
            redirectToPaymentPage();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private void redirectToPaymentPage() {
        showSnackBar("Redirecting to OneConnect Payment Gateway ...");
        StringBuilder sb = new StringBuilder();
        sb.append("&PAY_REQUEST_ID=").append(requestID);
        sb.append("&CHECKSUM=").append(checksum);
        Log.d(TAG, "redirectToPaymentPage: PARAMETERS: ".concat(sb.toString()));

        try {
            byte[] parms = EncodingUtils.getBytes(sb.toString(),"BASE64");
            Log.w(TAG, "redirectToPaymentPage: ".concat(sb.toString())
                    + " \n" + PayGateConstants.PAYGATE_REDIRECT_URL  + " \nencodedParams: " + parms);

            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            WebViewClient webViewClient = new WebViewClient();
            webView.setWebViewClient(webViewClient);

            webView.postUrl(PayGateConstants.PAYGATE_REDIRECT_URL, parms);
        } catch (Exception e) {
            Log.e(TAG, "redirectToPaymentPage: ", e );
            showSnackBar("Redirect to Payment Gateway failed", "Close", "#f44336");
        }


        //startBrowser(sb.toString());
    }


//    private void startBrowser(String parms) {
//        String url = PayGateConstants.PAYGATE_REDIRECT_URL + "?" + parms;
//        Log.w(TAG, "startBrowser: url: ".concat(url) );
//        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//        startActivity(intent);
//    }
    private Snackbar snackbar;

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
    private void showSnackBar(String title) {
        snackbar = Snackbar.make(toolbar, title, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

//    class ATask extends AsyncTask<Void,Void,Integer> {
//
//        String html;
//
//        @Override
//        protected Integer doInBackground(Void... voids) {
//            OkHttpClient client = new OkHttpClient();
//            RequestBody formBody = new FormBody.Builder()
////                    .add("PAYGATE_ID", PayGateConstants.MERCHANT_PAYGATE_ID)
//                    .add("PAY_REQUEST_ID", requestID)
//                    .add("CHECKSUM",checksum)
//                    .build();
//            Request request = new Request.Builder()
//                    .url(PayGateConstants.PAYGATE_REDIRECT_URL)
//                    .post(formBody)
//                    .build();
//
//            Log.e(TAG, "doInBackground: method: "+ request.method() + " body: " + request.body().toString()
//            + " contentType: " + request.body().contentType() + " url: " + request.url().toString());
//            try {
//                Response okResponse = client.newCall(request).execute();
//                html = new String(okResponse.body().string());
//                Log.i(TAG,".........response from MyGate, content:  " + html);
//
//
//            } catch (Exception ex) {
//                Log.e(TAG, "doInBackground: FAILED", ex );
//                return 9;
//            }
//            return 0;
//        }
//        @Override
//        protected void onPostExecute(Integer result) {
//            Log.i(TAG, "onPostExecute: ........... result: "+result);
//            if (result == 0) {
//                //todo load html
//                webView.loadData(html,"text/html","UTF-8");
//            }
//        }
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_payment_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favourite) {
            return true;
        }
        if (id == R.id.action_info) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    Visa
4000000000000002
Authenticated (AX) *
MasterCard
5200000000000015
Authenticated (AX)
American Express
378282246310005
Not Authenticated (NX)
M-Pesa
N/A; enter MR PASS in First & Last Name field.
Authenticated (AX) Insufficient Funds Transactions. RESULT_CODE = 900003; TRANSACTION_STATUS = 2.
MasterCard
5200000000000023
Not Authenticated (NX) *
Visa
4000000000000028
Not Authenticated (NX)
American Express
371449635398431
Not Authenticated (NX) Declined Transactions. RESULT_CODE = 900007; TRANSACTION_STATUS = 2.
Visa
4000000000000036
Authenticated (AX) *
MasterCard
5200000000000049
Authenticated (AX) *
Diners Club
30569309025904
Not Applicable (XX)
M-Pesa
N/A; enter MR FAIL in First & Last Name field
Not Applicable (XX) Invalid Card Number. RESULT_CODE = 900004; TRANSACTION_STATUS = 2.
For credit card payment method - all other card numbers
Not Applicable (XX) Unprocessed Transactions. RESUT_CODE = 990022; TRANSACTION_STATUS = 0.
MasterCard
5200000000000064
Not Applicable (XX)
Expiry Date must be in the future; Card Holder & CVV can be made up.
* Using these card numbers will allow you to test the MasterCard SecureCode / Verified-by-Visa authentication process.
     */
}
