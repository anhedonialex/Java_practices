package com.example.p2_14;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et;
    public static final String LOG_TAG = "ny_app_tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnLoad = findViewById(R.id.btnLoad);
        et = findViewById(R.id.etValue);
        //Log.e(LOG_TAG,""+getExternalFilesDir(null));
        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int btnId = v.getId();
        if (!checkPermission()){
            requestPermissions();
        }else if (btnId == R.id.btnSave){
            String text = et.getText().toString();
            if(!text.isEmpty()){
                //File dirPath = getFilesDir();
                File dirPath = new File("/storage/emulated/0/");
                File filePath = new File(dirPath, "simple_text.txt");
                try{
                    FilesUtils.saveTextToFile(filePath, text);
                    Log.d(LOG_TAG, "File saved to: " + filePath.getAbsolutePath());
                } catch(IOException e){
                    Log.e(LOG_TAG, "Error saving: " + e.getMessage());
                }
            }else{
                Toast.makeText(this, R.string.no_empty_field, Toast.LENGTH_LONG).show();
            }
        } else if (btnId == R.id.btnLoad) {
            //File dirPath = getFilesDir();
            File dirPath = new File("/storage/emulated/0/");
            File filePath = new File(dirPath, "simple_text.txt");
            try {
                String textEt = FilesUtils.loadTextFromFile(filePath);
                et.setText(textEt);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            Log.e(LOG_TAG, "lol");
        }

    }
    private void requestPermissions(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            try{
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(String.format("package:%s", getPackageName())));
                startActivityForResult(intent, 12345);

            }catch (Exception e){
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                startActivityForResult(intent, 12345);
            }
        } else {
            ActivityCompat.requestPermissions(this, new String[] {WRITE_EXTERNAL_STORAGE},12345);
        }
    }
    private boolean checkPermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            return Environment.isExternalStorageManager();
        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            return ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        } else{
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 12345){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
                if(checkPermission()){
                    Toast.makeText(this, "Получено", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this, "Не получено", Toast.LENGTH_LONG).show();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 12345){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Получено", Toast.LENGTH_LONG).show();
            } else{
                Toast.makeText(this, "Не получено", Toast.LENGTH_LONG).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}