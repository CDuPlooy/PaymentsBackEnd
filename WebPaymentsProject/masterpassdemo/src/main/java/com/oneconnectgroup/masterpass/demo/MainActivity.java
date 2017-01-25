package com.oneconnectgroup.masterpass.demo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oltio.liblite.activity.LibLiteActivity;
import com.oneconnect.payments.paymentApi.model.MasterPassRequestDTO;
import com.oneconnect.payments.paymentApi.model.MasterPassResponseDTO;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    FloatingActionButton fab;
    MasterPassRequestDTO request;
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    Snackbar snackbar;
    Button btn;
    TextInputEditText editAmount;
    TextView txtDate;
    static final SimpleDateFormat sdf = new SimpleDateFormat("MMMM, yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MasterPass Demo");
        getSupportActionBar().setSubtitle("OneConnect Payment Gateway");
        progressDialog = new ProgressDialog(this);



        setFields();

        //500100010001055539
        //500100010001059919
    }

    public static final int REQUEST_PAYMENT = 757;
    private ProgressDialog progressDialog;
    private void requestPayment(String code) {
        Log.w(TAG, "requestPayment: requesting MasterPass take over the payment flow via LibLiteActivity" );
        Intent intent = new Intent(this, LibLiteActivity.class);
        intent.putExtra(LibLiteActivity.IN_CODE, code);
        intent.putExtra(LibLiteActivity.IN_API_KEY, Constants.API_LIBLITE_TOKEN);
        intent.putExtra(LibLiteActivity.IN_SYSTEM, "TEST");
        this.startActivityForResult(intent, REQUEST_PAYMENT);
    }

    private void setFields() {
        txtDate = (TextView) findViewById(R.id.date);
        txtDate.setText(sdf.format(new Date()));
        editAmount = (TextInputEditText) findViewById(R.id.amount);
        editAmount.setText("");
        btn = (Button) findViewById(R.id.btn);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.w(TAG, "onClick: sending ...\n" + GSON.toJson(request));
                startMasterPass();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMasterPass();
            }
        });
    }

    private void startMasterPass() {
        if (TextUtils.isEmpty(editAmount.getText())) {
            Toast.makeText(this,"Please enter amount", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Processing payment request");
        progressDialog.show();

        disableButtons();

        request = new MasterPassRequestDTO();
        double amt = Double.parseDouble(editAmount.getText().toString());
        request.setAmount(amt);
        request.setRequestType(1);
        request.setExpiryDate(new DateTime().plusYears(2).getMillis());
        request.setMerchantReference("ONECONNECT-" + System.currentTimeMillis());
        request.setShortDescription("OneConnect: Payment Transaction Test");

        MasterPassUtil.getTransactionCode(request, new MasterPassUtil.MasterPassListener() {
            @Override
            public void onResponse(final MasterPassResponseDTO response) {
                Log.i(TAG, "onResponse: \n" + GSON.toJson(response));
                progressDialog.dismiss();
                if (response == null) {
                    snackbar = Snackbar.make(toolbar, "Error from MasterPass", Snackbar.LENGTH_INDEFINITE);
                    snackbar.setActionTextColor(Color.parseColor("red"));

                } else {
                    if (response.getStatusCode() == 0) {
                        requestPayment(response.getCodeResponse().getCode());
                        snackbar = Snackbar.make(toolbar, response.getMessage(), Snackbar.LENGTH_INDEFINITE);
                        snackbar.setActionTextColor(Color.parseColor("yellow"));
                    } else {
                        snackbar = Snackbar.make(toolbar, response.getMessage()
                                + " (" + response.getStatusCode() + ")", Snackbar.LENGTH_INDEFINITE);
                        snackbar.setActionTextColor(Color.parseColor("red"));
                    }
                }

                snackbar.setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                }) ;
                snackbar.show();
            }

            @Override
            public void onError(String message) {
                showSnackBar(message,"BAD SHIT!","red");
            }
        });
    }

    private void disableButtons() {
        fab.setEnabled(false);
        btn.setEnabled(false);
        fab.setAlpha(0.3f);
        btn.setAlpha(0.3f);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG, "onActivityResult: LibLiteActivity returns, resultCode: " + resultCode);
        enableButtons();
        switch (requestCode) {
            case REQUEST_PAYMENT:
                if (resultCode == LibLiteActivity.LIBLITE_ERROR) {
                    int error_code = data.getIntExtra(LibLiteActivity.OUT_ERROR_CODE, -1);
                    int location = data.getIntExtra(LibLiteActivity.OUT_LOCATION, -1);
                    onLibraryError(error_code,location);
                } else if (resultCode == LibLiteActivity.LIBLITE_PAYMENT_SUCCESS) {
                    String txReference = data.getStringExtra(LibLiteActivity.OUT_TX_REFERENCE);
                    onSuccess(txReference);
                } else if (resultCode == LibLiteActivity.LIBLITE_PAYMENT_FAILED) {
                    String txReference = data.getStringExtra(LibLiteActivity.OUT_TX_REFERENCE);
                    onFailure(txReference);
                } else if (resultCode == LibLiteActivity.LIBLITE_USER_CANCELLED) {
                    int location = data.getIntExtra(LibLiteActivity.OUT_LOCATION, -1);
                    onUserCancelled(location);
                } else if (resultCode == LibLiteActivity.LIBLITE_INVALID_CODE) {
                    onInvalidCode();
                }
                break;
        }
    }

    private void enableButtons() {
        fab.setEnabled(true);
        btn.setEnabled(true);
        fab.setAlpha(1.0f);
        btn.setAlpha(1.0f);
    }

    private void onSuccess(String reference) {
         showSnackBar("Payment Successful, REF: " + reference,"OK","green");
    }
    private void onFailure(String reference) {
        showSnackBar("Payment Failed, REF: " + reference,"OK","red");
    }
    private void onUserCancelled(int location) {
        showSnackBar("User cancelled Transaction","OK","cyan");
    }
    private void onInvalidCode() {
        showSnackBar("Invalid MasterPass Code ","OK","red");
    }
    private void onLibraryError(int errorCode, int location) {
        showSnackBar("MasterPass Library Error ","BAD","red");
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
