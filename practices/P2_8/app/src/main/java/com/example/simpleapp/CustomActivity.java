package com.example.simpleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        EditText etVal = findViewById(R.id.etValue);
        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(v->{
            String strData = etVal.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("data",strData);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}