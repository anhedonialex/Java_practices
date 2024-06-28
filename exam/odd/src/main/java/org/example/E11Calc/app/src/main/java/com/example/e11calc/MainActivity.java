package com.example.e11calc;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText e1 = findViewById(R.id.editText1);
        EditText e2 = findViewById(R.id.editText2);
        TextView tv = findViewById(R.id.textView);
        Button sum = findViewById(R.id.button);
        sum.setOnClickListener(v->{
            Log.i("Hint", "Кнопка нажата");
            String e1_val = e1.getText().toString();
            String e2_val = e2.getText().toString();
            if (!e1_val.isEmpty() && !e2_val.isEmpty()){
                int result = Integer.parseInt(e1_val) + Integer.parseInt(e2_val);
                Log.i("Sum", String.valueOf(result));
                tv.setText(String.valueOf(result));
            }
            else{
                Toast.makeText(getApplicationContext(), "Вы ввели кринж", Toast.LENGTH_LONG).show();
            }
        });
    }

}