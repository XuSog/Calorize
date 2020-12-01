package com.example.healthcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class WesternActivity extends AppCompatActivity {


    CustomImageButton aglioOlioButton;
    CustomImageButton chickenChopButton;
    CustomImageButton friedRiceButton;
    CustomImageButton spaghettiBologneseButton;


    public static String KEY="food";

    ArrayList<String> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.western_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setBackgroundColor(Color.rgb(218, 149, 82));
        toolbar.setTitle("Western");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

        aglioOlioButton=findViewById(R.id.aglioOlioButton);
        chickenChopButton=findViewById(R.id.chickenChopButton);
        friedRiceButton=findViewById(R.id.friedRiceButton);
        spaghettiBologneseButton=findViewById(R.id.spaghettiBologneseButton);


        aglioOlioButton.setText("Aglio Olio");
        aglioOlioButton.setTextSize(80f);
        aglioOlioButton.setColor(Color.BLACK);


        chickenChopButton.setText("Chicken Chop");
        chickenChopButton.setTextSize(80f);
        chickenChopButton.setColor(Color.BLACK);

        friedRiceButton.setText("Fried Rice");
        friedRiceButton.setColor(Color.BLACK);
        friedRiceButton.setTextSize(80f);

        spaghettiBologneseButton.setText("Spaghetti Bolognese");
        spaghettiBologneseButton.setTextSize(80f);
        spaghettiBologneseButton.setColor(Color.BLACK);



        aglioOlioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WesternActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("AGLIO OLIO");
                data.add("408");
                data.add("17.4");
                data.add("9.28");
                data.add("20");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        chickenChopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WesternActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("CHICKEN CHOP");
                data.add("679");
                data.add("12.5");
                data.add("15.5");
                data.add("117");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        friedRiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WesternActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("FRIED RICE");
                data.add("430");
                data.add("12.5");
                data.add("15.5");
                data.add("117");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        spaghettiBologneseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WesternActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("SPAGHETTI BOLOGNESE");
                data.add("254");
                data.add("14.3");
                data.add("2.9");
                data.add("17");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });
    }
}