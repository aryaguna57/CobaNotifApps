package com.cobacoba.cobacoba;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.cobacoba.cobacoba.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);

        final EditText etLink = findViewById(R.id.etLink);

        final LinearLayout layoutNodata = findViewById(R.id.no_list);

        Button btnAdd = findViewById(R.id.button_add);
        Button btnQR = findViewById(R.id.button_QR);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etLink != null){
                    String text = etLink.getText().toString();
                    Intent data = new Intent(AddActivity.this,MainActivity.class);
                    data.putExtra(EXTRA_TEXT,text);
                    startActivity(data);
                }
            }
        });

        btnQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openScannerku();
            }
        });
    }

    public void openScannerku(){
        Intent qr = new Intent(this, QRActivity.class);
        startActivity(qr);
    }
}
