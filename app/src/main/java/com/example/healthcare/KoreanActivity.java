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

public class KoreanActivity extends AppCompatActivity {

    CustomImageButton plateSabaFishSetButton;
    CustomImageButton plateChickenSetButton;
    CustomImageButton plateBeefSetButton;
    CustomImageButton plateSabaFishNChickenSetButton;

    CustomImageButton beefRamenButton;
    CustomImageButton kimichiRamenButton;
    CustomImageButton dumplingRamenButton;

    CustomImageButton kimchiSoupButton;
    CustomImageButton fishFilletRamenButton;
    CustomImageButton fryEbiNChickenKatsuBentoButton;


    CustomImageButton chickenKatsuNScallopBentoButton;
    CustomImageButton fishFilletNChickenKatsuBentoButton;
    CustomImageButton sabaFishNChickenKatsuBentoButton;
    CustomImageButton salmonFishNChickenKatsuBentoButton;
    CustomImageButton salmonFishNPrawnBallBentoButton;


    CustomImageButton fishFilletNFryEbiBentoButton;
    CustomImageButton chickenKatsuSetButton;
    CustomImageButton chickenKatsuNJapaneseCurryRiceButton;
    CustomImageButton chickenKatsuNPrawnBallBentoButton;
    CustomImageButton chickenMeatButton;
    CustomImageButton chickenLiverButton;
    CustomImageButton friedRiceButton;

    public static String KEY="food";

    ArrayList<String> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.korean_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setBackgroundColor(Color.rgb(218, 149, 82));
        toolbar.setTitle("Korean");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

        plateSabaFishSetButton=findViewById(R.id.plateSabaFishSetButton);
        plateChickenSetButton=findViewById(R.id.plateChickenSetButton);
        plateBeefSetButton=findViewById(R.id.plateBeefSetButton);
        plateSabaFishNChickenSetButton=findViewById(R.id.plateSabaFishNChickenSetButton);
        beefRamenButton=findViewById(R.id.beefRamenButton);
        kimichiRamenButton=findViewById(R.id.kimichiRamenButton);
        dumplingRamenButton=findViewById(R.id.dumplingRamenButton);
        chickenMeatButton=findViewById(R.id.chickenMeatButton);
        chickenLiverButton=findViewById(R.id.chickenLiverButton);
        kimchiSoupButton=findViewById(R.id.kimichiSoupButton);
        friedRiceButton=findViewById(R.id.friedRiceButton);
        fishFilletRamenButton=findViewById(R.id.fishFilletRamenButton);
        fryEbiNChickenKatsuBentoButton=findViewById(R.id.fryEbiNChickenKatsuBentoButton);
        chickenKatsuNJapaneseCurryRiceButton=findViewById(R.id.chickenKatsuNJapaneseCurryRiceButton);
        chickenKatsuNPrawnBallBentoButton=findViewById(R.id.chickenKatsuNPrawnBallBentoButton);
        chickenKatsuNScallopBentoButton=findViewById(R.id.chickenKatsuNScallopBentoButton);
        chickenKatsuSetButton=findViewById(R.id.chickenKatsuSetButton);
        fishFilletNChickenKatsuBentoButton=findViewById(R.id.fishFilletNChickenKatsuBentoButton);
        sabaFishNChickenKatsuBentoButton=findViewById(R.id.sabaFishNChickenKatsuBentoButton);
        salmonFishNChickenKatsuBentoButton=findViewById(R.id.salmonFishNChickenKatsuBentoButton);
        salmonFishNPrawnBallBentoButton=findViewById(R.id.salmonFishNPrawnBallBentoButton);
        fishFilletNFryEbiBentoButton=findViewById(R.id.fishFilletNFryEbiBentoButton);
        friedRiceButton=findViewById(R.id.friedRiceButton);

        plateSabaFishSetButton.setText("Plate Saba Fish Set");
        plateSabaFishSetButton.setTextSize(80f);
        plateSabaFishSetButton.setColor(Color.BLACK);

        plateChickenSetButton.setText("Plate Chicken Set");
        plateChickenSetButton.setTextSize(80f);
        plateChickenSetButton.setColor(Color.BLACK);

        plateBeefSetButton.setText("Plate Beef Set");
        plateBeefSetButton.setTextSize(80f);
        plateBeefSetButton.setColor(Color.BLACK);

        plateSabaFishNChickenSetButton.setText("Plate Saba Fish N Chicken Set");
        plateSabaFishNChickenSetButton.setColor(Color.BLACK);
        plateSabaFishNChickenSetButton.setTextSize(80f);

        beefRamenButton.setText("Beef Ramen");
        beefRamenButton.setColor(Color.BLACK);
        beefRamenButton.setTextSize(80f);

        kimichiRamenButton.setText("Kimchi Ramen");
        kimichiRamenButton.setTextSize(80f);
        kimichiRamenButton.setColor(Color.BLACK);

        dumplingRamenButton.setText("Dumpling Ramen");
        dumplingRamenButton.setColor(Color.BLACK);
        dumplingRamenButton.setTextSize(80f);

        fishFilletRamenButton.setText("Fish Fillet");
        fishFilletRamenButton.setTextSize(80f);
        fishFilletRamenButton.setColor(Color.BLACK);

        fryEbiNChickenKatsuBentoButton.setText("Fry Ebi N Chicken Katsu Set Bento");
        fryEbiNChickenKatsuBentoButton.setColor(Color.BLACK);
        fryEbiNChickenKatsuBentoButton.setTextSize(80f);

        chickenKatsuNScallopBentoButton.setText("Chicken Katsu N Scallop Bento");
        chickenKatsuNScallopBentoButton.setColor(Color.BLACK);
        chickenKatsuNScallopBentoButton.setTextSize(80f);

        fishFilletNChickenKatsuBentoButton.setText("Fish Fillet N Chicken Katsu Bento");
        fishFilletNChickenKatsuBentoButton.setColor(Color.BLACK);
        fishFilletNChickenKatsuBentoButton.setTextSize(80f);

        chickenKatsuNJapaneseCurryRiceButton.setText("Chicken Katsu N Japanese Curry Rice Button");
        chickenKatsuNJapaneseCurryRiceButton.setColor(Color.BLACK);
        chickenKatsuNJapaneseCurryRiceButton.setTextSize(80f);

        sabaFishNChickenKatsuBentoButton.setText("Saba Fish N Chicken Katsu");
        sabaFishNChickenKatsuBentoButton.setColor(Color.BLACK);
        sabaFishNChickenKatsuBentoButton.setTextSize(80f);

        salmonFishNChickenKatsuBentoButton.setText("Salmon Fish N Chicken Katsu Bento");
        salmonFishNChickenKatsuBentoButton.setColor(Color.BLACK);
        salmonFishNChickenKatsuBentoButton.setTextSize(80f);

        salmonFishNPrawnBallBentoButton.setText("Salmon Fish N Prawn Ball Bento");
        salmonFishNPrawnBallBentoButton.setColor(Color.BLACK);
        salmonFishNPrawnBallBentoButton.setTextSize(80f);

        fishFilletNFryEbiBentoButton.setText("Salmon Fish N Fry Ebi Bento");
        fishFilletNFryEbiBentoButton.setColor(Color.BLACK);
        fishFilletNFryEbiBentoButton.setTextSize(80f);
        chickenKatsuSetButton.setText("Chicken Katsu Set");
        chickenKatsuSetButton.setColor(Color.BLACK);
        chickenKatsuSetButton.setTextSize(80f);

        chickenKatsuNJapaneseCurryRiceButton.setText("Chicken Katsu N Japanese Curry Rice");
        fishFilletNFryEbiBentoButton.setColor(Color.BLACK);
        fishFilletNFryEbiBentoButton.setTextSize(80f);

        chickenKatsuNPrawnBallBentoButton.setText("Chicken Katsu N Prawn Ball Bento");
        chickenKatsuNPrawnBallBentoButton.setColor(Color.BLACK);
        chickenKatsuNPrawnBallBentoButton.setTextSize(80f);

        kimchiSoupButton.setText("Kimchi Soup");
        kimchiSoupButton.setColor(Color.BLACK);
        kimchiSoupButton.setTextSize(80f);

        friedRiceButton.setText("Fried Rice");
        friedRiceButton.setColor(Color.BLACK);
        friedRiceButton.setTextSize(80f);

        plateSabaFishSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("PLATE SABA FISH SET");
                data.add("470");
                data.add("17.6");
                data.add("13.6");
                data.add("26");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        plateChickenSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("PLATE CHICKEN SET");
                data.add("485");
                data.add("24");
                data.add("14");
                data.add("61");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        plateBeefSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("PLATE BEEF SET");
                data.add("475");
                data.add("21");
                data.add("14");
                data.add("53");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        plateSabaFishNChickenSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("PLATE SABA FISH N CHICKEN SET");
                data.add("478");
                data.add("20");
                data.add("13");
                data.add("44");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        beefRamenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("BEEF RAMEN");
                data.add("518");
                data.add("37");
                data.add("26");
                data.add("260");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        kimichiRamenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("KIMCHI RAMEN");
                data.add("505");
                data.add("31");
                data.add("23");
                data.add("207");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        dumplingRamenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("DUMPLING RAMEN");
                data.add("513");
                data.add("25");
                data.add("23");
                data.add("216");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        fishFilletRamenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("FISH FILLET RAMEN");
                data.add("608");
                data.add("24");
                data.add("28");
                data.add("113");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        fryEbiNChickenKatsuBentoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("FRY EBI N CHICKEN KATSU BENTO");
                data.add("567");
                data.add("16");
                data.add("18");
                data.add("16");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        chickenKatsuNScallopBentoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("CHICKEN KATSU N SCALLOP BENTO");
                data.add("462");
                data.add("18");
                data.add("10");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        fishFilletNChickenKatsuBentoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("FISH FILLET N CHICKEN KATSU BENTO");
                data.add("608");
                data.add("15");
                data.add("17");
                data.add("7");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });


        sabaFishNChickenKatsuBentoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("SABA FISH N CHICKEN KATSU BENTO");
                data.add("485");
                data.add("18");
                data.add("12");
                data.add("13");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        salmonFishNPrawnBallBentoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("SALMON FISH N CHICKEN KATSU BENTO");
                data.add("457");
                data.add("24");
                data.add("9");
                data.add("26");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        fishFilletNFryEbiBentoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("Fish FILLET N FRY EBI BENTO");
                data.add("696");
                data.add("14");
                data.add("24");
                data.add("25");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        chickenKatsuSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("CHICKEN KATSU SET");
                data.add("567");
                data.add("19");
                data.add("17");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        chickenKatsuNJapaneseCurryRiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("CHICKEN KATSU N JAPANESE CURRY RICE");
                data.add("485");
                data.add("16");
                data.add("14");
                data.add("34");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        chickenKatsuNPrawnBallBentoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("CHICKEN KATSU N PRAWN BALL BENTO");
                data.add("497");
                data.add("20");
                data.add("12");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        kimchiSoupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("KIMCHI SOUP");
                data.add("497");
                data.add("20");
                data.add("12");
                data.add("0");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        salmonFishNChickenKatsuBentoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("SALMON FISH N CHICKEN KATSU BENTO");
                data.add("485");
                data.add("18");
                data.add("12");
                data.add("13");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });

        friedRiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KoreanActivity.this, FoodDetail.class);
                KEY="food";
                data.clear();
                data.add("FRIED RICE");
                data.add("613");
                data.add("23");
                data.add("31");
                data.add("345");
                intent.putExtra(KEY,data);
                intent.putExtra("picture", R.drawable.sys1d);  // R.drawable.sys1d to be replaced!
                startActivity(intent);
            }
        });
    }
}