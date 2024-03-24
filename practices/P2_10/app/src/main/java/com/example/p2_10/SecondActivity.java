package com.example.p2_10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity implements PersonAdapter.OnPersonClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        ActionBar ab = getSupportActionBar();
        if (ab != null){
            ab.setTitle("Second");
            ab.setHomeButtonEnabled(true);
            ab.setDisplayHomeAsUpEnabled(true);
        }
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Ivan", "Ivanov",19,null));
        persons.add(new Person("Petya", "Petrov",18,null));
        persons.add(new Person("Masha", "Mashina",28,null));
        persons.add(new Person("John", "Wick",45,null));
        RecyclerView rcView = findViewById(R.id.recyclerView);
        PersonAdapter adapter = new PersonAdapter(persons, this);
        rcView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false));
        rcView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.simple_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_favorite) {
            Toast.makeText(this, "Clicked favorite icon on Toolbar", Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.action_update) {
            Toast.makeText(this, "Clicked update on Toolbar", Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.action_exit) {
            finish();
            return true;
        } else if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPersonClick(Person person, int position) {
        Toast.makeText(this, "Click on" + person.getFirstName() + " " + person.getLastName(),Toast.LENGTH_LONG).show();
    }
}