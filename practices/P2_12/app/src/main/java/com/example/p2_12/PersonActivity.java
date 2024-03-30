package com.example.p2_12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class PersonActivity extends AppCompatActivity implements PersonAdapter.OnPersonClickListener{
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null,1));
        ArrayList<Person> persons = this.dbManager.loadAllPersonsFromDatabase();
        RecyclerView rcView = findViewById(R.id.recyclerView);
        PersonAdapter adapter = new PersonAdapter(persons, this);
        rcView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false));
        rcView.setAdapter(adapter);
    }
    @Override
    public void onPersonClick(Person person, int position) {
        Toast.makeText(this, "Click on " + person.getFirstName() + " " + person.getLastName(),Toast.LENGTH_LONG).show();
    }
}