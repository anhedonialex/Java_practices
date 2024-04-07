package com.example.p2_14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et;
    private PrefManager prefManager;
    public static final String LOG_TAG = "ny_app_tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnLoad = findViewById(R.id.btnLoad);
        et = findViewById(R.id.etValue);
        //Log.e(LOG_TAG,""+getExternalFilesDir(null));
        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);
        prefManager = new PrefManager(this);
        et.setText(prefManager.getDefaultTextValue());
    }

    @Override
    public void onClick(View v) {
        /*if(v.getId() == R.id.btnLoad){
            AssetManager am = getApplicationContext().getAssets();
            InputStream is;
            try{
                is = am.open("example.txt");
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer))!=-1){
                    result.write(buffer, 0, length);
                }
                String data = result.toString();
                is.close();
                et.setText(data);
            }catch (IOException e){
                e.printStackTrace();
            }
        }*/
        if(v.getId() == R.id.btnSave){
            String text = et.getText().toString();
            if(!text.isEmpty()){
                prefManager.saveDefaultTextValue(text);
            }else{
                Toast.makeText(this, R.string.no_empty_field, Toast.LENGTH_LONG).show();
            }
        }
    }
}