package com.example.e17saveinside;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFileName;
    private EditText editTextContent;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFileName = findViewById(R.id.editTextFileName);
        editTextContent = findViewById(R.id.editTextContent);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFile();
            }
        });
    }

    private void saveToFile() {
        final String fileName = editTextFileName.getText().toString().trim();
        final String content = editTextContent.getText().toString().trim();

        if (fileName.isEmpty()) {
            showToast("Введите имя файла");
            return;
        }

        if (content.isEmpty()) {
            showToast("Введите текст для сохранения");
            return;
        }

        // Создаем новый поток для сохранения файла
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                saveToFileInInternalStorage(fileName, content);
                Looper.loop();
            }
        }).start();
    }

    private void saveToFileInInternalStorage(String fileName, String content) {
        FileOutputStream fos = null;
        try {
            // Получаем директорию внутреннего хранилища приложения
            File directory = getFilesDir();
            File file = new File(directory, fileName);

            fos = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
            outputStreamWriter.write(content);
            outputStreamWriter.close();

            // Показываем сообщение в основном потоке с помощью Handler
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    showToast("Файл успешно сохранен: " + fileName);
                    showToast(directory.toString());
                    Log.i("",directory.toString());
                    ///data/user/0/com.example.e17saveinside/files
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            showToast("Ошибка при сохранении файла: " + e.getMessage());
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void showToast(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
