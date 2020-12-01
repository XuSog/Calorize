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

public class MuslimActivity extends AppCompatActivity {


    CustomImageButton nasiLemakButton;
    CustomImageButton meeRebusButton;
    CustomImageButton beefSatayButton;
    CustomImageButton ketupatButton;


    public static String KEY="food";

    ArrayList<String> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muslim_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setBackgroundColor(Color.rgb(218, 149, 82));
        toolbar.setTitle("Muslim");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

        nasiLemakButton=findViewById(R.id.nasiLemakButton);
        meeRebusButton=findViewById(R.id.meeRebusButton);
        beefSatayButton=findViewById(R.id.beefSatayButton);
        ketupatButton=findViewById(R.id.ketupatButton);

        nasiLemakButton.setText("Nasi Lemak");
        nasiLemakButton.setTextSize(80f);
        nasiLemakButton.setColor(Color.BLACK);

        meeRebusButton.setText("Mee Rebus");
        meeRebusButton.setTextSize(80f);
        meeRebusButton.setColor(Color.BLACK);

        beefSatayButton.setText("Beef Satay");
        beefSatayButton.setColor(Color.BLACK);
        beefSatayButton.setTextSize(80f);


        ketupatButton.setText("Ketupat");
        ketupatButton.setTextSize(80f);
        ketupatButton.setColor(Color.BLACK);


        nasiLemakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MuslimActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("NASI LEMAK");
                data.add("656");
                data.add("26");
                data.add("24");
                data.add("117");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.nasilemakpic);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        meeRebusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MuslimActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("MEE REBUS");
                data.add("134");
                data.add("3");
                data.add("4");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.meerebuspic);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        beefSatayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MuslimActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("BEEF SATAY");
                data.add("168");
                data.add("12");
                data.add("5");
                data.add("114");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.beefsataypic);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        ketupatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MuslimActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("KETUPAT");
                data.add("87");
                data.add("2");
                data.add("0");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.ketupatpic);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });
    }
}
