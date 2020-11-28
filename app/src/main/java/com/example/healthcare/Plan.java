package com.example.healthcare;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Plan extends AppCompatActivity {
    TextView run,swim,bycicle,rope_skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan);
        run=findViewById(R.id.run);
        swim=findViewById(R.id.swim);
        bycicle=findViewById(R.id.bycicle);
        rope_skip=findViewById(R.id.rope_skip);
        run.setBackgroundColor(Integer.parseInt("#FF018786"));




    }
}