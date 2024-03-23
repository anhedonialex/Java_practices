package com.example.simpleapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnStart;
    private TextView tvTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStartActivity);
        tvTextValue = findViewById(R.id.tvText);
        btnStart.setOnClickListener(this);
    }
    ActivityResultLauncher<Intent> activityResultLaunch = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getData()!=null){
                        String str = result.getData().getStringExtra("data");
                        Log.d("simple_app_tag",str);
                    }
                }
            }
    );
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.btnStartActivity){
            //Intent actIntent = new Intent(getApplicationContext(),CustomActivity.class);
            //activityResultLaunch.launch(actIntent);
            /*Uri urilocation = Uri.parse("geo:55.754283,37.62002");
            Intent newIntent = new Intent(Intent.ACTION_VIEW);
            newIntent.setData(urilocation);
            startActivity(newIntent);*/
            /*Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.ACTION_SEND,"This is my text to send");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);*/
            Intent actIntent = new Intent(getApplicationContext(),TestFragmentActivity.class);
            startActivity(actIntent);
        }
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 12345){
            if(data!=null){
                String str = data.getStringExtra("data");
                Log.d("simple_app_tag", str);
            }
        }
    }*/
}