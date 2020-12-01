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

import java.util.ArrayList;

public class IndianActivity extends AppCompatActivity {

    CustomImageButton plainPrataButton;
    CustomImageButton eggPrataButton;
    CustomImageButton samosaButton;
    CustomImageButton riceButton;
    CustomImageButton idliButton;
    CustomImageButton dosaiButton;
    CustomImageButton chickenCurryButton;
    CustomImageButton fishCurryButton;
    CustomImageButton vegetableCurryButton;
    CustomImageButton chapatiButton;

    public static String KEY="food";

    ArrayList<String> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indian_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setBackgroundColor(Color.rgb(218, 149, 82));
        toolbar.setTitle("Indian");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

        plainPrataButton=findViewById(R.id.plainPrataButton);
        eggPrataButton=findViewById(R.id.eggPrataButton);
        samosaButton=findViewById(R.id.samosaButton);
        riceButton=findViewById(R.id.riceButton);
        idliButton=findViewById(R.id.idliButton);
        dosaiButton=findViewById(R.id.dosaiButton);
        chickenCurryButton=findViewById(R.id.chickenCurryButton);
        fishCurryButton=findViewById(R.id.fishCurryButton);
        vegetableCurryButton=findViewById(R.id.vegetableCurryButton);
        chapatiButton=findViewById(R.id.chapatiButton);

        plainPrataButton.setText("Plain Prata");
        plainPrataButton.setTextSize(80f);
        plainPrataButton.setColor(Color.BLACK);

        chapatiButton.setText("Chapati");
        chapatiButton.setTextSize(80f);
        chapatiButton.setColor(Color.BLACK);
        
        eggPrataButton.setText("Egg Prata");
        eggPrataButton.setTextSize(80f);
        eggPrataButton.setColor(Color.BLACK);

        samosaButton.setText("Samosa");
        samosaButton.setColor(Color.BLACK);
        samosaButton.setTextSize(80f);

        riceButton.setColor(Color.BLACK);
        riceButton.setTextSize(80f);

        riceButton.setText("Rice");
        riceButton.setColor(Color.BLACK);
        riceButton.setTextSize(80f);

        idliButton.setText("Idli");
        idliButton.setTextSize(80f);
        idliButton.setColor(Color.BLACK);

        dosaiButton.setText("Dosa");
        dosaiButton.setTextSize(80f);
        dosaiButton.setColor(Color.BLACK);

        chickenCurryButton.setText("Chicken Curry");
        chickenCurryButton.setTextSize(80f);
        chickenCurryButton.setColor(Color.BLACK);

        fishCurryButton.setText("Fish Curry");
        fishCurryButton.setTextSize(80f);
        fishCurryButton.setColor(Color.BLACK);

        vegetableCurryButton.setText("Vegetable Curry");
        vegetableCurryButton.setTextSize(80f);
        vegetableCurryButton.setColor(Color.BLACK);

        plainPrataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndianActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("PLAIN PRATA");
                data.add("162");
                data.add("5");
                data.add("7");
                data.add("190");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        eggPrataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndianActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("EGG PRATA");
                data.add("319");
                data.add("13");
                data.add("15");
                data.add("194");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        samosaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndianActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("SAMOSA");
                data.add("206");
                data.add("3");
                data.add("11");
                data.add("11");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        riceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndianActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("Rice");
                data.add("143");
                data.add("3");
                data.add("5");
                data.add("1");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        idliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndianActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("IDLI");
                data.add("352");
                data.add("6");
                data.add("15");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        dosaiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndianActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("DOSAI");
                data.add("97");
                data.add("2");
                data.add("2");
                data.add("1");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        chickenCurryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndianActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("CHICKEN CURRY");
                data.add("966");
                data.add("52");
                data.add("61");
                data.add("164");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });
        
        
        chapatiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndianActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("CHAPATI");  
                data.add("143");
                data.add("3");
                data.add("5");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        fishCurryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndianActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("FISH CURRY");
                data.add("214");
                data.add("14");
                data.add("17");
                data.add("36");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        vegetableCurryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndianActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("VEGETABLE CURRY");
                data.add("130");
                data.add("4");
                data.add("11");
                data.add("26");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });
    }
}
