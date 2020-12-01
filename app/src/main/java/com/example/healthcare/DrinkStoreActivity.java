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

public class DrinkStoreActivity extends AppCompatActivity {

    CustomImageButton miloButton;
    CustomImageButton kopiButton;
    CustomImageButton barleyButton;
    CustomImageButton tehButton;
    CustomImageButton kayaToastButton;
    CustomImageButton waffleButton;

    public static String KEY="food";

    ArrayList<String> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drinks_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setBackgroundColor(Color.rgb(218, 149, 82));
        toolbar.setTitle("Drinks");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

        miloButton=findViewById(R.id.miloButton);
        kopiButton=findViewById(R.id.kopiButton);
        barleyButton=findViewById(R.id.barleyButton);
        tehButton=findViewById(R.id.tehButton);
        kayaToastButton=findViewById(R.id.kayaToastButton);
        waffleButton=findViewById(R.id.waffleButton);

        miloButton.setText("Milo");
        miloButton.setTextSize(80f);
        miloButton.setColor(Color.BLACK);

        kopiButton.setText("Kopi");
        kopiButton.setTextSize(80f);
        kopiButton.setColor(Color.BLACK);

        barleyButton.setText("Barley");
        barleyButton.setColor(Color.BLACK);
        barleyButton.setTextSize(80f);

        tehButton.setText("teh");
        tehButton.setColor(Color.BLACK);
        tehButton.setTextSize(80f);

        kayaToastButton.setText("Kaya Toast");
        kayaToastButton.setTextSize(80f);
        kayaToastButton.setColor(Color.BLACK);

        waffleButton.setText("Waffle");
        waffleButton.setTextSize(80f);
        waffleButton.setColor(Color.BLACK);

        miloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrinkStoreActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("MILO");
                data.add("120");
                data.add("3.75");
                data.add("3.25");
                data.add("9");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.milopic);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        kopiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrinkStoreActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("KOPI");
                data.add("134");
                data.add("3");
                data.add("4");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.kopipic);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        barleyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrinkStoreActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("BARLEY");
                data.add("54");
                data.add("0");
                data.add("0");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.barleypic);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        tehButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrinkStoreActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("TEH");
                data.add("0");
                data.add("0");
                data.add("0");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.tehpic);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        kayaToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrinkStoreActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("KAYA TOAST");
                data.add("108");
                data.add("1");
                data.add("4");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.toastpic);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        waffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrinkStoreActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("WAFFLE");
                data.add("352");
                data.add("6");
                data.add("15");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.wafflepic);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });
    }
}
