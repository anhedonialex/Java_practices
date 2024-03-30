package com.example.p2_12;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TelephoneActivity extends AppCompatActivity implements TelephoneAdapter.onTelephoneClickListener{
    private IndividualDBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephone);
        this.dbManager = new IndividualDBManager(new IndividualMyAppSQLiteHelper(this, "individual_my_database.db", null,1));
        ArrayList<Telephone> telephones = this.dbManager.loadAllTelephonesFromDatabase();
        RecyclerView rcView = findViewById(R.id.recyclerView);
        TelephoneAdapter adapter = new TelephoneAdapter(telephones, this);
        rcView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false));
        rcView.setAdapter(adapter);
    }
    @Override
    public void onTelephoneClick(Telephone phone, int position) {
        Toast.makeText(this, "Click on " + phone.getModel() + " " + phone.getSerial(),Toast.LENGTH_LONG).show();
        Log.i("My app","Click on " + phone.getModel() + " " + phone.getSerial());
    }
}