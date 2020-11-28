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

public class HealthySoupActivity extends AppCompatActivity {

    CustomImageButton porkSoupButton;
    CustomImageButton whiteRiceButton;
    CustomImageButton brownRiceButton;
    CustomImageButton vegetableButton;
    CustomImageButton tofuButton;
    CustomImageButton pigEarButton;
    CustomImageButton pigTongueButton;
    CustomImageButton chickenMeatButton;
    CustomImageButton chickenLiverButton;

    public static String KEY="";

    ArrayList<String> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthy_soup_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setBackgroundColor(Color.BLACK);
        toolbar.setTitle("Healthy Soup");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

        porkSoupButton=findViewById(R.id.porkSoupButton);
        whiteRiceButton=findViewById(R.id.whiteRiceButton);
        brownRiceButton=findViewById(R.id.brownRiceButton);
        vegetableButton=findViewById(R.id.vegetableButton);
        tofuButton=findViewById(R.id.tofuButton);
        pigEarButton=findViewById(R.id.pigEarButton);
        pigTongueButton=findViewById(R.id.pigTongueButton);
        chickenMeatButton=findViewById(R.id.chickenMeatButton);
        chickenLiverButton=findViewById(R.id.chickenLiverButton);

        porkSoupButton.setText("Pork Soup");
        porkSoupButton.setTextSize(80f);
        porkSoupButton.setColor(Color.BLACK);


        whiteRiceButton.setText("White Rice");
        whiteRiceButton.setTextSize(80f);
        whiteRiceButton.setColor(Color.BLACK);

        brownRiceButton.setText("Brown Rice");
        brownRiceButton.setColor(Color.BLACK);
        brownRiceButton.setTextSize(80f);

        vegetableButton.setText("Vegetable");
        vegetableButton.setTextSize(80f);
        vegetableButton.setColor(Color.BLACK);

        tofuButton.setText("Tofu");
        tofuButton.setColor(Color.BLACK);
        tofuButton.setTextSize(80f);

        pigEarButton.setText("Pig Ear");
        pigEarButton.setTextSize(80f);
        pigEarButton.setColor(Color.BLACK);

        pigTongueButton.setText("Pig Tongue");
        pigTongueButton.setColor(Color.BLACK);
        pigTongueButton.setTextSize(80f);

        chickenMeatButton.setText("Chicken Meat");
        chickenMeatButton.setTextSize(80f);
        chickenMeatButton.setColor(Color.BLACK);

        chickenLiverButton.setText("Chicken Liver");
        chickenLiverButton.setColor(Color.BLACK);
        chickenLiverButton.setTextSize(80f);



        porkSoupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthySoupActivity.this, FoodDetail.class);
                KEY="PORK SOUP KEY";
                data.clear();
                data.add("PORK SOUP");
                data.add("144.41");
                data.add("18");
                data.add("6");
                data.add("41.36");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        whiteRiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthySoupActivity.this, FoodDetail.class);
                KEY="WHITE RICE KEY";
                data.clear();
                data.add("WHITE RICE");
                data.add("280");
                data.add("5.6");
                data.add("1");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        brownRiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthySoupActivity.this, FoodDetail.class);
                KEY="BROWN RICE KEY";
                data.clear();
                data.add("BROWN RICE");
                data.add("262");
                data.add("2.7");
                data.add("2.52");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        vegetableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthySoupActivity.this, FoodDetail.class);
                KEY="VEGETABLE KEY";
                data.clear();
                data.add("VEGETABLE");
                data.add("6.34");
                data.add("0.40");
                data.add("0");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        tofuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthySoupActivity.this, FoodDetail.class);
                KEY="TOFU KEY";
                data.clear();
                data.add("TOFU");
                data.add("48.6");
                data.add("4.86");
                data.add("2.21");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        pigEarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthySoupActivity.this, FoodDetail.class);
                KEY="PIG EAR KEY";
                data.clear();
                data.add("PIG EAR");
                data.add("48");
                data.add("6.77");
                data.add("1.2");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        pigTongueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthySoupActivity.this, FoodDetail.class);
                KEY="PIG TONGUE KEY";
                data.clear();
                data.add("PIG TONGUE");
                data.add("135");
                data.add("9.6");
                data.add("10.2");
                data.add("60.6");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        chickenMeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthySoupActivity.this, FoodDetail.class);
                KEY="CHICKEN MEAT KEY";
                data.clear();
                data.add("CHICKEN MEAT");
                data.add("87.8");
                data.add("7.59");
                data.add("6.16");
                data.add("30.6");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        chickenLiverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthySoupActivity.this, FoodDetail.class);
                KEY="CHICKEN LIVER KEY";
                data.clear();
                data.add("CHICKEN LIVER");
                data.add("94.3");
                data.add("14.6");
                data.add("3.27");
                data.add("378.8");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });
    }
}