package com.example.simpleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class TestFragmentActivity extends AppCompatActivity {
    private int counterFragments = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);
        Fragment exampleFrg1 = new FirstFragment();
        Fragment exampleFrg2 = new SecondFragment();
        Button btnChange = findViewById(R.id.btnChangeFragment);
        btnChange.setOnClickListener(v ->{
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if(counterFragments % 2 == 0){
                ft.replace(R.id.relativeContainer,exampleFrg2);
            }else{
                ft.replace(R.id.relativeContainer, exampleFrg1);
            }
            ft.commit();
            counterFragments++;
        });
    }
}