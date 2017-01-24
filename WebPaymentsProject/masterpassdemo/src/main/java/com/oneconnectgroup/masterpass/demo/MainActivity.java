package com.oneconnectgroup.masterpass.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oltio.liblite.activity.LibLiteActivity;
import com.oneconnect.payments.paymentApi.model.MasterPassRequestDTO;
import com.oneconnect.payments.paymentApi.model.MasterPassResponseDTO;

import org.joda.time.DateTime;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    FloatingActionButton fab;
    MasterPassRequestDTO request;
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MasterPass Demo");
        getSupportActionBar().setSubtitle("Testing Payment Gateway");


        request = new MasterPassRequestDTO();
        request.setAmount(550.78);
        request.setRequestType(1);
        request.setExpiryDate(new DateTime().plusYears(2).getMillis());
        request.setMerchantReference("ONECONNECT-" + System.currentTimeMillis());
        request.setShortDescription("OneConnect Test Code Request");

        setFields();
    }

    private void requestPayment() {
        Intent intent = new Intent(this, LibLiteActivity.class);
        intent.putExtra(LibLiteActivity.IN_CODE, "1234567890");
        intent.putExtra(LibLiteActivity.IN_API_KEY, "APIKEY");
        intent.putExtra(LibLiteActivity.IN_SYSTEM, "LIVE");
        this.startActivityForResult(intent, 10);
    }

    private void setFields() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.w(TAG, "onClick: sending ...\n" + GSON.toJson(request));
                MasterPassUtil.getTransactionCode(request, new MasterPassUtil.MasterPassListener() {
                    @Override
                    public void onResponse(MasterPassResponseDTO response) {
                        Log.i(TAG, "onResponse: \n" + GSON.toJson(response));
                        snackbar = Snackbar.make(toolbar, response.getMessage()
                                + " (" + response.getStatusCode() + ")", Snackbar.LENGTH_INDEFINITE);
                        snackbar.show();
                    }

                    @Override
                    public void onError(String message) {

                    }
                });
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 10:
                if (resultCode == LibLiteActivity.LIBLITE_ERROR) {
                    int error_code = data.getIntExtra(LibLiteActivity.OUT_ERROR_CODE, -1);
                    int location = data.getIntExtra(LibLiteActivity.OUT_LOCATION, -1); //...
                } else if (resultCode == LibLiteActivity.LIBLITE_PAYMENT_SUCCESS) {
                    String txReference = data.getStringExtra(LibLiteActivity.OUT_TX_REFERENCE); //...
                } else if (resultCode == LibLiteActivity.LIBLITE_PAYMENT_FAILED) {
                    String txReference = data.getStringExtra(LibLiteActivity.OUT_TX_REFERENCE); //...
                } else if (resultCode == LibLiteActivity.LIBLITE_USER_CANCELLED) {
                    int location = data.getIntExtra(LibLiteActivity.OUT_LOCATION, -1); //...
                } else if (resultCode == LibLiteActivity.LIBLITE_INVALID_CODE) { ///**/...
                }
                break;
        }
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
