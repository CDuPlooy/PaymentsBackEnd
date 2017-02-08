package com.oneconnectgroup.payuapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnectgroup.payuapp.payu.AdditionalInfo;
import com.oneconnectgroup.payuapp.payu.Basket;
import com.oneconnectgroup.payuapp.payu.Customer;
import com.oneconnectgroup.payuapp.payu.PayUResponseDTO;
import com.oneconnectgroup.payuapp.payu.SetTransaction;
import com.oneconnectgroup.payuapp.payu.TransactionType;

public class PayUActivity extends AppCompatActivity implements PayUUtil.PayUListener {

    public static final String TAG = PayUActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_u);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTestTransaction();
            }
        });
        setTestTransaction();
    }
      private void setTestTransaction() {
          SetTransaction t = new SetTransaction();
          t.setTransactionType(TransactionType.PAYMENT);

          Customer c = new Customer();
          c.setEmail("aubreym@oneconnectgroup.com");
          c.setFirstName("Aubrey");
          c.setLastName("Malabie");
          c.setCountryCode("ZA");
          c.setMobile("0710441887");
          t.setCustomer(c);

          AdditionalInfo info = new AdditionalInfo();
          info.setCancelUrl(PayUUtil.CANCEL_URL);
          info.setDevicePlatform("Android");
          info.setNotificationUrl(PayUUtil.NOTIFY_URL);
          info.setReturnUrl(PayUUtil.RETURN_URL);
          info.setDemoMode("True");
          info.setLocale("en");
          info.setMerchantReference("OneConnect-"+System.currentTimeMillis());
          info.setSupportedPaymentMethods(PayUUtil.PAYMENT_METHODS);
          t.setAdditionalInformation(info);

          Basket b = new Basket();
          b.setDescription("Municipality Payment");
          b.setAmountInCents("56499");
          b.setCurrencyCode("ZAR");
          t.setBasket(b);

          PayUUtil.setTransaction(t, new PayUUtil.PayUListener() {
              @Override
              public void onResponse(PayUResponseDTO response) {
                  Log.i(TAG, "onResponse: ".concat(GSON.toJson(response)));
              }

              @Override
              public void onError(String message) {
                  Log.e(TAG, "onError: ".concat(message) );
              }
          });
      }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pay_u, menu);
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

    @Override
    public void onResponse(PayUResponseDTO response) {
        Log.i(TAG, "onResponse: ######## from PayU: " + GSON.toJson(response));
    }

    @Override
    public void onError(String message) {
        Log.e(TAG, "onError: " + message );
    }

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
}
