package com.example.p2_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //private EditText editTextFirstName, editTextLastName, editTextAge;
    private EditText editTextModel, editTextSerial, editTextPrice;
    private IndividualDBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null,1));
        this.dbManager = new IndividualDBManager(new IndividualMyAppSQLiteHelper(this, "individual_my_database.db", null,1));
        /*
        editTextFirstName = findViewById(R.id.etFirstName);
        editTextLastName = findViewById(R.id.etLastName);
        editTextAge = findViewById(R.id.etAge);
        */
        editTextModel = findViewById(R.id.etModel);
        editTextSerial = findViewById(R.id.etSerial);
        editTextPrice = findViewById(R.id.etPrice);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnNext = findViewById(R.id.btnNext);
        btnAdd.setOnClickListener(this);
        btnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAdd){
            if(this.dbManager != null){
                /*
                String fName = editTextFirstName.getText().toString();
                String lName = editTextLastName.getText().toString();
                String age = editTextAge.getText().toString();*/
                String model = editTextModel.getText().toString();
                String serial = editTextSerial.getText().toString();
                String price = editTextPrice.getText().toString();
                if(!model.isEmpty() && !serial.isEmpty() && !price.isEmpty()){
                    boolean result = dbManager.saveTelephoneToDatabase(new Telephone(model, serial, Integer.parseInt(price)));
                    if(result){
                        Toast.makeText(this, R.string.insert_success, Toast.LENGTH_LONG).show();
                        Log.i("My app", getResources().getString(R.string.insert_success));
                    }else{
                        Toast.makeText(this, R.string.insert_error, Toast.LENGTH_LONG).show();
                        Log.i("My app", getResources().getString(R.string.insert_error));
                    }
                }else{
                    Toast.makeText(this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
                    Log.i("My app", getResources().getString(R.string.incorrect_value));
                }
            }
        }else if (v.getId() == R.id.btnNext){
            //startActivity(new Intent(this, PersonActivity.class));
            startActivity(new Intent(this, TelephoneActivity.class));
            Log.i("My app","Goin to TelephoneActivity");
        }
    }
}