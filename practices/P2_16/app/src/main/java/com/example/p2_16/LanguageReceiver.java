package com.example.p2_16;

import static com.example.p2_16.MyCustomApp.LOG_TAG;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class LanguageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(LOG_TAG, "onReceive message!");
        Toast.makeText(context.getApplicationContext(),
                context.getString(R.string.lang_change),
                Toast.LENGTH_LONG).show();
    }
}