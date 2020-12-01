package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.prefs.Preferences;

public class CanteenActivity extends AppCompatActivity {
    CustomImageButton drinksButton;
    CustomImageButton muslimButton;
    CustomImageButton indianButton;
    CustomImageButton japKoreanButton;
    CustomImageButton healthySoupButton;
    CustomImageButton chickenRiceButton;
    CustomImageButton westernButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canteen_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setBackgroundColor(Color.BLACK);
        toolbar.setTitle("Select Store");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

        drinksButton=findViewById(R.id.drinksStoreButton);
        muslimButton=findViewById(R.id.muslimStoreButton);
        indianButton=findViewById(R.id.indianStoreButton);
        japKoreanButton=findViewById(R.id.japKoreanStoreButton);
        healthySoupButton=findViewById(R.id.healthySoupStoreButton);
        chickenRiceButton=findViewById(R.id.chickenRiceStoreButton);
        westernButton=findViewById(R.id.westernStoreButton);

        drinksButton.setColor(Color.BLACK);
        drinksButton.setTextSize(80f);

        muslimButton.setColor(Color.BLACK);
        muslimButton.setTextSize(80f);

        indianButton.setColor(Color.BLACK);
        indianButton.setTextSize(80f);

        japKoreanButton.setColor(Color.BLACK);
        japKoreanButton.setTextSize(80f);

        healthySoupButton.setColor(Color.BLACK);
        healthySoupButton.setTextSize(80f);

        chickenRiceButton.setColor(Color.BLACK);
        chickenRiceButton.setTextSize(80f);

        westernButton.setColor(Color.BLACK);
        westernButton.setTextSize(80f);


        healthySoupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CanteenActivity.this, HealthySoupActivity.class);
                startActivity(intent);

            }
        });

        drinksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CanteenActivity.this, DrinkStoreActivity.class);
                startActivity(intent);

            }
        });

        muslimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CanteenActivity.this, MuslimActivity.class);
                startActivity(intent);

            }
        });
        indianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CanteenActivity.this, IndianActivity.class);
                startActivity(intent);

            }
        });
        japKoreanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CanteenActivity.this, KoreanActivity.class);
                startActivity(intent);

            }
        });
        chickenRiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CanteenActivity.this, ChickenRiceActivity.class);
                startActivity(intent);

            }
        });
        westernButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CanteenActivity.this, WesternActivity.class);
                startActivity(intent);

            }
        });









    }


}
