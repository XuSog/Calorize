package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
        setContentView(R.layout.medal_and_profile_photo);

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
        if (unlocked_photo_list!=null) {
            for (String i : unlocked_photo_list) {
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
        if (unlocked_medal_list!=null){
            for (String i:unlocked_medal_list){
                unlock_medal(i);
            }
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (Medal_and_photo.this,MainActivity.class);
                intent.putExtra("pic",R.drawable.p00);
                startActivity(intent);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (Medal_and_photo.this,MainActivity.class);
                intent.putExtra("pic",R.drawable.p01);
                startActivity(intent);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (Medal_and_photo.this,MainActivity.class);
                intent.putExtra("pic",R.drawable.p10);
                startActivity(intent);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (Medal_and_photo.this,MainActivity.class);
                intent.putExtra("pic",R.drawable.p11);
                startActivity(intent);

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (Medal_and_photo.this,MainActivity.class);
                intent.putExtra("pic",R.drawable.p20);
                startActivity(intent);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (Medal_and_photo.this,MainActivity.class);
                intent.putExtra("pic",R.drawable.p21);
                startActivity(intent);

            }
        });









    }
    void unlock_medal(String str){
        ImageView i ;

        if (str=="one_day_medal"){
            i=findViewById(R.id.one_day_medal);
            i.setImageResource(R.drawable.one_day);}
        if (str=="three_day_medal"){
            i=findViewById(R.id.three_day_medal);
            i.setImageResource(R.drawable.three_day);}
        if (str=="seven_day_medal"){
            i=findViewById(R.id.seven_day_medal);
            i.setImageResource(R.drawable.one_month);}
        if (str=="one_month_medal"){
            i=findViewById(R.id.one_month_medal);
            i.setImageResource(R.drawable.one_day);
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


}