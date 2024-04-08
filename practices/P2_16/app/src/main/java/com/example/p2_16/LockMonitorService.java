package com.example.p2_16;

import static com.example.p2_16.MyCustomApp.LOG_TAG;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;

public class LockMonitorService extends Service {
    private Handler handler = new Handler(Looper.getMainLooper());
    class MonitoringRunnable implements Runnable{
        @Override
        public void run() {
            checkPhoneScreenLocked();
            handler.postDelayed(this, 2000);
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @SuppressLint("ForegroundServiceType")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "MonitorService started");
        NotificationHelper notificationHelper = new NotificationHelper(this);
        Notification n = notificationHelper.createNotification("Мониторинг", "Сервис наблюдения запущен",12345);
        startForeground(12345, n);
        handler.post(new MonitoringRunnable());
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(LOG_TAG, "MonitorService destroyed");
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
    private void checkPhoneScreenLocked(){
        KeyguardManager km = (KeyguardManager)
                getApplicationContext().getSystemService(Context.KEYGUARD_SERVICE);
        if(km.isKeyguardLocked()) {
            Log.d(LOG_TAG,"Phone is locked");
        } else {
            Log.d(LOG_TAG,"Phone is not locked");
        }
    }
}