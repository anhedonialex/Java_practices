package com.example.e15sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    private MessageDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MessageDatabaseHelper(this);

        Button buttonCreateDb = findViewById(R.id.button_create_db);
        buttonCreateDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Открытие базы данных (создание, если не существует)
                dbHelper.getWritableDatabase();
                Log.i("", "БД создана");

            }
        });
        Button buttonAddMessage = findViewById(R.id.button_add_message);
        buttonAddMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Добавление сообщения в базу данных
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                dbHelper.addMessage("Hello, World!", timeStamp, false);
            }
        });
        Button buttonShowMessages = findViewById(R.id.button_show_messages);
        buttonShowMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получение и вывод всех сообщений в логах
                Cursor cursor = dbHelper.getAllMessages();
                if (cursor.moveToFirst()) {
                    do {
                        int id = cursor.getInt(cursor.getColumnIndexOrThrow(MessageDatabaseHelper.COLUMN_ID));
                        String body = cursor.getString(cursor.getColumnIndexOrThrow(MessageDatabaseHelper.COLUMN_BODY));
                        String timestamp = cursor.getString(cursor.getColumnIndexOrThrow(MessageDatabaseHelper.COLUMN_TIMESTAMP));
                        int isRead = cursor.getInt(cursor.getColumnIndexOrThrow(MessageDatabaseHelper.COLUMN_IS_READ));
                        Log.i("", "Message ID: " + id + ", Body: " + body + ", Timestamp: " + timestamp + ", Is Read: " + (isRead == 1));
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });

    }
}