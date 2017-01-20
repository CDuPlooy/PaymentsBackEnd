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

import com.oneconnect.payemts.backend.paymentApi.model.InitiateTransactionDTO;
import com.oneconnect.payemts.backend.paymentApi.model.TransactionResponseDTO;

import com.oneconnectgroup.webpayments.app.api.PayGateUtil;

public class MainActivity extends AppCompatActivity {

    public static final String
            RETURN_URL = "http://192.168.1.233:8083/payGateReturn",
            NOTIFY_URL = "http://192.168.1.233:8083/payGateNotify",
            TAG = MainActivity.class.getSimpleName();
    TextView txt;
    FloatingActionButton fab;

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
        InitiateTransactionDTO it = new InitiateTransactionDTO();
        it.setAmount("10598");
        it.setReturnURL(RETURN_URL);
        it.setNotifyURL(NOTIFY_URL);
        it.setUser1("AubreyM");
        it.setReference("REF4564678-K5F4");


        PayGateUtil.startTransaction(it, new PayGateUtil.PaymentListener() {
            @Override
            public void onResponse(TransactionResponseDTO response) {
                Log.i(TAG, "onResponse: ");
                txt.setText("Response from Server: " + response.getMessage());
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
