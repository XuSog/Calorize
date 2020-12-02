package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Medal_and_photo extends AppCompatActivity {
    ArrayList<String> unlocked_medal_list=new ArrayList<>();
    ArrayList<String> unlocked_photo_list=new ArrayList<>();
    Date date_0;
    int app_using_days=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
        Data.check_status_for_medal_and_photo();
        setContentView(R.layout.medal_and_profile_photo);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setBackgroundColor(Color.rgb(218, 149, 82));
        toolbar.setTitle("Achievements & Rewards");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

        date_0=new java.util.Date();

        if (date_0.toString().substring(0,7)!=MainActivity.get_Date().toString().substring(0,7)){
            app_using_days=app_using_days+1;
        }

        if (app_using_days>=1){
            unlocked_medal_list.add("one_day_medal" );
            unlocked_photo_list.add("0");
        }

        if (app_using_days>=3){
            unlocked_medal_list.add("three_day_medal");
            unlocked_photo_list.add("1");
        }

        if (app_using_days>=7){
            unlocked_medal_list.add("seven_day_medal");
            unlocked_photo_list.add("20");
        }
        if (app_using_days>=30){
            unlocked_medal_list.add("one_month_medal");
            unlocked_photo_list.add("21");

        }
        Button b1,b2,b3,b4,b5,b6;
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        if (Data.unlocked_photo_list_data!=null) {
            for (String i : Data.unlocked_photo_list_data) {
                unlock_photo(i);
                if (i=="0"){
                    b1.setEnabled(true);
                    b2.setEnabled(true);
                }
                if (i=="1"){
                    b3.setEnabled(true);
                    b4.setEnabled(true);
                }
                if (i=="20"){
                    b5.setEnabled(true);

                }
                if (i=="21"){
                    b6.setEnabled(true);
                }
            }
        }
        if (Data.unlocked_medal_list_data!=null){
            for (String i:Data.unlocked_medal_list_data){
                unlock_medal(i);
            }
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                SharedPreferences sharedPreferences = getSharedPreferences("medal data", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("pic", "00");
                editor.apply();
                finish();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                SharedPreferences sharedPreferences = getSharedPreferences("medal data", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("pic", "01");
                editor.apply();
                finish();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                SharedPreferences sharedPreferences = getSharedPreferences("medal data", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("pic", "10");
                editor.apply();
                finish();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                SharedPreferences sharedPreferences = getSharedPreferences("medal data", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("pic", "11");
                editor.apply();
                finish();

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                SharedPreferences sharedPreferences = getSharedPreferences("medal data", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("pic", "20");
                editor.apply();
                finish();

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                SharedPreferences sharedPreferences = getSharedPreferences("medal data", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("pic", "21");
                editor.apply();
                finish();
            }
        });

    }

    @Override
    protected void onPause() {
        saveData();
        super.onPause();
    }

    void unlock_medal(String str){
        ImageView i ;
        TextView x;

        if (str=="one_day_medal"){
            i=findViewById(R.id.one_day_medal);
            x=findViewById(R.id.B1);
            x.setText("Keep healthy diet for 1 day (Completed)");
            i.setImageResource(R.drawable.one_day);}

        if (str=="three_day_medal"){
            i=findViewById(R.id.three_day_medal);
            i.setImageResource(R.drawable.three_day);
            x=findViewById(R.id.B2);
            x.setText("Keep healthy diet for 3 days (Completed)");}

        if (str=="seven_day_medal"){
            i=findViewById(R.id.seven_day_medal);
            i.setImageResource(R.drawable.one_month);
            x=findViewById(R.id.B3);
            x.setText("Keep healthy diet for 7 days (Completed)");}
        if (str=="one_month_medal"){
            i=findViewById(R.id.one_month_medal);
            i.setImageResource(R.drawable.one_month);
            x=findViewById(R.id.B4);
            x.setText("Keep healthy diet for 1 month (Completed)");
        }


    }

    void unlock_photo(String str){
        ImageView i;
        if (str=="0"){
            i=findViewById(R.id.p00);
            i.setImageResource(R.drawable.p00);
            i=findViewById(R.id.p01);
            i.setImageResource(R.drawable.p01);
        }
        if (str=="1"){
            i=findViewById(R.id.p10);
            i.setImageResource(R.drawable.p10);
            i=findViewById(R.id.p11);
            i.setImageResource(R.drawable.p11);
        }
        if (str=="20") {
            i = findViewById(R.id.p20);
            i.setImageResource(R.drawable.p20);
        }
        if (str=="21"){
            i=findViewById(R.id.p21);
            i.setImageResource(R.drawable.p21);
        }
    }


    void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("medal data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("one", String.valueOf(Data.using_app_days_data));
        Gson gson = new Gson();
        String json = gson.toJson(Data.unlocked_medal_list_data);
        editor.putString("two", json);
        gson = new Gson();
        json = gson.toJson(Data.unlocked_photo_list_data);
        editor.putString("three", json);
        editor.putString("four", String.valueOf(Data.date_0_data));
        editor.putString("five", String.valueOf(Data.first_use));

        editor.commit();

    }

    void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("medal data", MODE_PRIVATE);
        String s1 = sharedPreferences.getString("one", "0");
        Data.using_app_days_data = Integer.valueOf(s1);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("two", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        ArrayList<String> data = gson.fromJson(json, type);
        if (data != null) {
            Data.unlocked_medal_list_data = data;
        } else{
            Data.unlocked_medal_list_data = new ArrayList<String>();
        }
        gson = new Gson();
        json = sharedPreferences.getString("three", null);
        type = new TypeToken<ArrayList<String>>() {}.getType();
        data = gson.fromJson(json, type);
        if (data != null) {
            Data.unlocked_photo_list_data = data;
        } else{
            Data.unlocked_photo_list_data = new ArrayList<String>();
        }
        s1 = sharedPreferences.getString("four", String.valueOf(new Date()));
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
        try {
            Date date = formatter.parse(s1);
            Data.date_0_data = date;
        } catch (ParseException e) {
            Data.date_0_data = new Date();
        }
        s1 = sharedPreferences.getString("five", "0");
        Data.first_use = Integer.valueOf(s1);
    }

}