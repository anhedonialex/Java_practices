package com.example.firstapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener{
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);
        EditText editTextFirst = findViewById(R.id.etFirst);
        EditText editTextSecond = findViewById(R.id.etSecond);
        TextView textViewResult = findViewById(R.id.tvResult);
        Button btnCalc = findViewById(R.id.btnStart);
        btnCalc.setOnClickListener(v->{
            Log.i("simple_app_tag","Click calc button");
            String firstTermStr = editTextFirst.getText().toString();
            String secondTermStr = editTextSecond.getText().toString();
            if(!firstTermStr.isEmpty() && !secondTermStr.isEmpty()){
                int result = Integer.parseInt(firstTermStr)+Integer.parseInt(secondTermStr);
                Log.i("simple_app_tag","Result calculation: " + result);
                textViewResult.setText(String.valueOf(result));
            }else {
                Log.w("simple_app_tag", "Empty term!");
                Toast.makeText(getApplicationContext(),"Invalid terms", Toast.LENGTH_LONG).show();
            }

        });
    }*/
        setContentView(R.layout.activity_individual);
        Button btnCalc = findViewById(R.id.btnStart);
        btnCalc.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){

        EditText editTextFirst = findViewById(R.id.etFirst);
        EditText editTextSecond = findViewById(R.id.etSecond);
        EditText editTextThird = findViewById(R.id.etThird);
        String firstTermStr = editTextFirst.getText().toString();
        String secondTermStr = editTextSecond.getText().toString();
        String thirdTermStr = editTextThird.getText().toString();
        TextView textViewResult = findViewById(R.id.tvResult);
        if(!firstTermStr.isEmpty() && !secondTermStr.isEmpty()) {
            int durationMonths = Integer.parseInt(firstTermStr);
            double annualInterestRate = Integer.parseInt(secondTermStr);
            double initialAmount = Integer.parseInt(thirdTermStr);

            // Вычисление ежемесячного дохода и итогового дохода
            double monthlyInterestRate = annualInterestRate / 12 / 100;
            double totalAmount = initialAmount;

            for (int month = 1; month <= durationMonths; month++) {
                double interest = totalAmount * monthlyInterestRate;
                totalAmount += interest;
                //System.out.printf("Месяц %d: Доход %.2f, Итоговая сумма %.2f%n", month, interest, totalAmount);
            }
            textViewResult.setText(String.valueOf(totalAmount));
            Log.i("total_amount_tag", String.format("Итоговая сумма вклада через %d месяцев: %.2f%n", durationMonths, totalAmount));
            // Вывод итоговой суммы
            //System.out.printf("Итоговая сумма вклада через %d месяцев: %.2f%n", durationMonths, totalAmount);
        }else {
            Log.w("simple_app_tag", "Empty term!");
            Toast.makeText(getApplicationContext(),"Invalid terms", Toast.LENGTH_LONG).show();
        }
    }
    /*@Override
    public void onClick(View v){
        Log.i("simple_app_tag","Click start button");
        TextView textViewFirst = findViewById(R.id.tvWelcome);
        TextView textViewSecond = findViewById(R.id.tvBye);
        textViewFirst.setText("Начало");
        textViewSecond.setText("Конец");
    }
    @Override
    public boolean onLongClick(View v){
        Log.i("simple_app_tag","Long click start button");
        return true;
    }*/

}