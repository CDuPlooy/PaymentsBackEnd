package com.oneconnectgroup.paygatedemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oneconnect.payments.paymentApi.model.PayGateInitiateRequestDTO;
import com.oneconnect.payments.paymentApi.model.PayGateResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class PayGateActivity extends AppCompatActivity {
    public static final String TAG = PayGateActivity.class.getSimpleName();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private Toolbar toolbar;
    TextInputEditText editAmount;
    Button btnSend;
    Spinner spinner;
    FloatingActionButton fab;
    List<PayMethod> payMethods;
    PayMethod payMethod;
    boolean isBusy;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_gate);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("PayGate Demo App");
        getSupportActionBar().setSubtitle("OneConnect Payment Gateway");

        setFields();
        setSpinner();
    }

    private void setSpinner() {
        payMethods = PayMethod.getList();
        List<String> list = new ArrayList<>();
        for (PayMethod pm : payMethods) {
            list.add(pm.getDescription());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                payMethod = payMethods.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setFields() {
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.setVisibility(View.GONE);
        spinner = (Spinner) findViewById(R.id.spinner);
        editAmount = (TextInputEditText) findViewById(R.id.editAmount);
        btnSend = (Button) findViewById(R.id.btnSend);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isBusy)
                    startTransaction();
                else showBusy();
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isBusy)
                    startTransaction();
                else showBusy();
            }
        });
    }

    private void showBusy() {
        Toast.makeText(this, "Transaction is still in process. Wait a sec!", Toast.LENGTH_LONG).show();
    }

    private void startTransaction() {
        if (TextUtils.isEmpty(editAmount.getText())) {
            Toast.makeText(getApplicationContext(), "Please enter Amount", Toast.LENGTH_SHORT).show();
            return;
        }

        final PayGateInitiateRequestDTO req = new PayGateInitiateRequestDTO();
        req.setReference("OneConnect-".concat("" + System.currentTimeMillis()));

        double m = Double.parseDouble(editAmount.getText().toString());
        int i = (int) (m * 100);
        req.setAmount(i);
        req.setEmail("aubreym@oneconnectgroup.com");
        req.setUser1("AubreyM");
        req.setPayMethod(payMethod.getCode());

        Log.d(TAG, "startTransaction: ".concat(GSON.toJson(req)));
        showSnackBar("Starting PayGate Transaction ...", "OK", "yellow");
        isBusy = true;
        chronometer.setVisibility(View.VISIBLE);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.setFormat("Time - %s");
        chronometer.start();
        btnSend.setVisibility(View.GONE);
        PayGateUtil.initiateTransaction(req, new PayGateUtil.PayGateListener() {
            @Override
            public void onResponse(PayGateResponseDTO response) {
                Log.i(TAG, "onResponse: " + GSON.toJson(response));
                isBusy = false;
                chronometer.stop();
                chronometer.setVisibility(View.GONE);
                btnSend.setVisibility(View.VISIBLE);
                if (response.getPayGateInitiateTranResponse().getStatusCode() == 0) {
                    String requestID = response.getPayGateInitiateTranResponse().getPayRequestID();
                    String ref = response.getPayGateInitiateTranResponse().getReference();
                    Log.w(TAG, "onResponse: requestID: " + requestID + " ref: " + ref);

                    //redirect to PayGate Payment Page
                    Intent m = new Intent(getApplicationContext(), PaymentPageActivity.class);
                    m.putExtra("requestID", requestID);
                    m.putExtra("reference", ref);
                    startActivity(m);
                } else {
                    showSnackBar("Transaction Initiation failed", "Close", "red");
                }
            }

            @Override
            public void onError(String message) {
                Log.e(TAG, "onError: ".concat(message));
                showSnackBar(message, "NotOK", "red");
            }
        });
    }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pay_gate, menu);
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
