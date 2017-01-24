package com.oneconnectgroup.masterpass.demo;

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

    private void setFields() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.w(TAG, "onClick: sending ...\n" + GSON.toJson(request) );
                MasterPassUtil.getTransactionCode(request, new MasterPassUtil.MasterPassListener() {
                    @Override
                    public void onResponse(MasterPassResponseDTO response) {
                        Log.i(TAG, "onResponse: \n" + GSON.toJson(response));
                        snackbar = Snackbar.make(toolbar,response.getMessage()
                                + " (" + response.getStatusCode() + ")",Snackbar.LENGTH_INDEFINITE);
                        snackbar.show();
                    }

                    @Override
                    public void onError(String message) {

                    }
                });
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
