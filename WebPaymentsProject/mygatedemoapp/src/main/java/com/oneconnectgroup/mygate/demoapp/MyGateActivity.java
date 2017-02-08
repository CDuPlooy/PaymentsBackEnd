package com.oneconnectgroup.mygate.demoapp;

import android.content.Intent;
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
import android.webkit.WebView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyGateActivity extends AppCompatActivity {

    Toolbar toolbar;
    Snackbar snackbar;
    FloatingActionButton fab;
    WebView webView;
    public static final String TAG = MyGateActivity.class.getSimpleName();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_gate);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test();
            }
        });
    }

    private void test() {
        MyGateRequestDTO m = new MyGateRequestDTO();
        m.setAmount(350.00);
        m.setMerchantReference("OneConnect-" + System.currentTimeMillis());

        MyGateUtil.startRequest(m, new MyGateUtil.MyGateListener() {
            @Override
            public void onResponse(MyGateResponseDTO response) {
                Log.i(TAG, "onResponse: " + GSON.toJson(response));
                showSnackBar("MyGate says OK", "Close", "green");
                Intent m = new Intent(getApplicationContext(),WebViewActivity.class);
                m.putExtra("html", response.getHtml());
                startActivity(m);
            }

            @Override
            public void onError(String message) {
                 showSnackBar(message,"OK","red");
            }
        });
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_gate, menu);
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
