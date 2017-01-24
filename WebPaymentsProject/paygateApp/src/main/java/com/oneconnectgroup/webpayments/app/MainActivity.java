package com.oneconnectgroup.webpayments.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnect.payments.paymentApi.model.CardPaymentRequestType;
import com.oneconnect.payments.paymentApi.model.PayGateAccountType;
import com.oneconnect.payments.paymentApi.model.PersonType;
import com.oneconnect.payments.paymentApi.model.SinglePaymentRequest;
import com.oneconnect.payments.paymentApi.model.SinglePaymentResponse;
import com.oneconnectgroup.webpayments.app.api.PayGateUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String
            RETURN_URL = "http://192.168.1.233:8083/payGateReturn",
            NOTIFY_URL = "http://192.168.1.233:8083/payGateNotify",
            SECRET = "secret",
            TAG = MainActivity.class.getSimpleName();
    TextView txt;
    FloatingActionButton fab;
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt = (TextView) findViewById(R.id.txtResponse);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTransaction();
            }
        });
    }

    private void startTransaction() {
        SinglePaymentRequest it = new SinglePaymentRequest();
        CardPaymentRequestType cardPaymentRequest = new CardPaymentRequestType();
        cardPaymentRequest.setCardNumber("4000000000000002");
        PersonType pt = new PersonType();
        pt.setTitle("Mr.");
        pt.setFirstName("Aubrey");
        pt.setLastName("Malabie");
        pt.setEmail(new ArrayList<String>());
        pt.getEmail().add("aubreym@oneconnectgroup.com");
        pt.setTelephone(new ArrayList<String>());
        pt.getTelephone().add("071 044 1887");
        pt.setNationality("South African");
        cardPaymentRequest.setCustomer(pt);
        cardPaymentRequest.setCardExpiryDate("2018-03");
        cardPaymentRequest.setCvv("897");
        PayGateAccountType pg = new PayGateAccountType();
        pg.setPayGateId("10011064270");
        pg.setPassword("test");
        cardPaymentRequest.setAccount(pg);
        it.setCardPaymentRequest(cardPaymentRequest);

//
//        it.setPayGateID(PAYGATE_ID);
//        it.setAmount("10598");
//        it.setReturnURL(RETURN_URL);
//        it.setNotifyURL(NOTIFY_URL);
//        it.setUser1("AubreyM");
//        it.setReference("REF4564678-K5F4");
//        it.setEmail("aubreym@oneconnectgroup.com");
//        it.setCountry("ZAF");
//        it.setCurrency("ZAR");
//        it.setLocale("en");
//        it.setTransactionDate(sdf.format(new Date()));
//        it.setCheckSum(calculateCheckSum(it));

        PayGateUtil.singlePaymentRequest(it, new PayGateUtil.PaymentListener() {
            @Override
            public void onResponse(SinglePaymentResponse response) {
                Log.i(TAG, "onResponse: "+ GSON.toJson(response));
                txt.setText("Response from Server: \n" + GSON.toJson(response));
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
