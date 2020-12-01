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

public class ChickenRiceActivity extends AppCompatActivity {


    CustomImageButton steamedChickenRiceButton;
    CustomImageButton braisedChickenRiceButton;
    CustomImageButton charSiewRiceButton;
    CustomImageButton wantonNoodleSoupButton;


    public static String KEY="food";

    ArrayList<String> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chicken_rice_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setBackgroundColor(Color.rgb(218, 149, 82));
        toolbar.setTitle("Chicken Rice");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

        steamedChickenRiceButton=findViewById(R.id.steamedChickenRiceButton);
        braisedChickenRiceButton=findViewById(R.id.braisedChickenRiceButton);
        charSiewRiceButton=findViewById(R.id.charSiewRiceButton);
        wantonNoodleSoupButton=findViewById(R.id.wantonNoodleSoupButton);


        steamedChickenRiceButton.setText("Steamed Chicken Rice");
        steamedChickenRiceButton.setTextSize(80f);
        steamedChickenRiceButton.setColor(Color.BLACK);


        braisedChickenRiceButton.setText("Braised Chicken Rice");
        braisedChickenRiceButton.setTextSize(80f);
        braisedChickenRiceButton.setColor(Color.BLACK);

        charSiewRiceButton.setText("Char Siew Rice");
        charSiewRiceButton.setColor(Color.BLACK);
        charSiewRiceButton.setTextSize(80f);

        wantonNoodleSoupButton.setText("Wanton Noodle Soup");
        wantonNoodleSoupButton.setTextSize(80f);
        wantonNoodleSoupButton.setColor(Color.BLACK);



        steamedChickenRiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChickenRiceActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("STEAMED CHICKEN RICE SOUP");
                data.add("557");
                data.add("28.0");
                data.add("13.8");
                data.add("36.6");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        braisedChickenRiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChickenRiceActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("BRAISED CHICKEN RICE");
                data.add("503");
                data.add("23.6");
                data.add("14.7");
                data.add("26.4");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        charSiewRiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChickenRiceActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("CHAR SIEW RICE");
                data.add("604");
                data.add("23.5");
                data.add("11.9");
                data.add("55.5");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        wantonNoodleSoupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChickenRiceActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("WANTON NOODLE SOUP");
                data.add("318");
                data.add("25.1");
                data.add("1.85");
                data.add("76.0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

    }
}