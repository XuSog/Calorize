package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.widget.Toolbar;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;

public class EnergyActivity extends AppCompatActivity {

    Double DayConsumeEnergy;
    Double WeekConsumeEnergy;
    Double MonthConsumeEnergy;
    String InputEnergy;

    Double DayDesireEnergy;
    Double WeekDesireEnergy;
    Double MonthDesireEnergy;

    Integer dayDate;
    Integer weekDate;
    Integer monthDate;

    Integer preDayDate;
    Integer preWeekDate;
    Integer preMonthDate;
    Calendar calendar = Calendar.getInstance();

    String height;
    String weight;
    String age;
    String gender;

    RadioGroup dateRadioGroup;
    RadioButton dayButton;
    RadioButton weekButton;
    RadioButton monthButton;
    TextView energyConsumeText;
    TextView energyDesireText;

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;

    public static final String sharedPrefFile = "com.example.android.mainsharedprefs";
    public static SharedPreferences mPreferences;

    public static final String DAY_DATE_KEY_2 = "DAY DATE KEY_2";
    public static final String WEEK_DATE_KEY_2 = "WEEK DATE KEY_2";
    public static final String MONTH_DATE_KEY_2 = "MONTH DATE KEY_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.energy_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setBackgroundColor(Color.rgb(218, 149, 82));
        toolbar.setTitle("Energy Tracking");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("data list", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        ArrayList<String> data = gson.fromJson(json, type);

        weight=data.get(2);
        height=data.get(3);
        age=data.get(4);
        gender=data.get(5);

        if (mPreferences != null) {
            DayConsumeEnergy = Double.valueOf(mPreferences.getString(FoodDetail.DAY_CONSUME_ENERGY_KEY, "0"));
            WeekConsumeEnergy = Double.valueOf(mPreferences.getString(FoodDetail.WEEK_CONSUME_ENERGY_KEY, "0"));
            MonthConsumeEnergy = Double.valueOf(mPreferences.getString(FoodDetail.MONTH_CONSUME_ENERGY_KEY, "0"));
        } else {
            weight = "60";
            height = "172";
            age = "20";
            gender = "male";

            DayConsumeEnergy = 0.0;
            WeekConsumeEnergy = 0.0;
            MonthDesireEnergy = 0.0;
        }

        dayDate = calendar.get(Calendar.DAY_OF_MONTH);
        weekDate = calendar.get(Calendar.DAY_OF_WEEK);
        monthDate = calendar.get(Calendar.MONTH);

        if (mPreferences != null) {
            preDayDate = mPreferences.getInt(DAY_DATE_KEY_2, -1);
            preWeekDate = mPreferences.getInt(WEEK_DATE_KEY_2, -1);
            preMonthDate = mPreferences.getInt(MONTH_DATE_KEY_2, -1);
        } else {
            preDayDate = -1;
            preWeekDate = -1;
            preMonthDate = -1;
        }

        if (dayDate != preDayDate) {
            DayConsumeEnergy = 0.0;
        }
        if (weekDate == 2 && weekDate != preWeekDate) {
            WeekConsumeEnergy = 0.0;
        } else if (preWeekDate == -1) {
            MonthConsumeEnergy = 0.0;
        }
        if (monthDate != preMonthDate) {
            MonthConsumeEnergy = 0.0;
        }
        Log.e("day", "" + dayDate);
        Log.e("week", weekDate + "");
        Log.e("month", "" + monthDate);


        DayDesireEnergy = new Get_desire_day_energy(Double.valueOf(height), Double.valueOf(weight), Integer.valueOf(age), gender).get_energy();
        WeekDesireEnergy = DayDesireEnergy * 7;
        MonthDesireEnergy = DayDesireEnergy * 30;

        energyConsumeText = findViewById(R.id.EnergyConsumeText);
        energyDesireText = findViewById(R.id.EnergyDesireText);

        dateRadioGroup = (RadioGroup) findViewById(R.id.dateRadioGroup);
        dayButton = (RadioButton) findViewById(R.id.dayButton);
        weekButton = (RadioButton) findViewById(R.id.weekButton);
        monthButton = (RadioButton) findViewById(R.id.monthButton);


        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        energyConsumeText.setText(Math.round(DayConsumeEnergy)+" Kcal");
        energyDesireText.setText(Math.round(DayDesireEnergy )+" Kcal");
        if(DayConsumeEnergy<=DayDesireEnergy){
            imageView1.setImageResource(R.drawable.thumbup);
            imageView2.setImageResource(R.drawable.thumbup);
            imageView3.setImageResource(R.drawable.thumbup);
        }else{
            imageView1.setImageResource(R.drawable.thumpdown);
            imageView2.setImageResource(R.drawable.thumpdown);
            imageView3.setImageResource(R.drawable.thumpdown);
        }
        dateRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (weekButton.getId() == checkedId) {

                    energyConsumeText.setText(Math.round(WeekConsumeEnergy )+" Kcal");
                    energyDesireText.setText(Math.round(WeekDesireEnergy )+" Kcal");
                    if(WeekConsumeEnergy<=WeekDesireEnergy){
                        imageView1.setImageResource(R.drawable.thumbup);
                        imageView2.setImageResource(R.drawable.thumbup);
                        imageView3.setImageResource(R.drawable.thumbup);
                    }else{
                        imageView1.setImageResource(R.drawable.thumpdown);
                        imageView2.setImageResource(R.drawable.thumpdown);
                        imageView3.setImageResource(R.drawable.thumpdown);
                    }

                } else if (monthButton.getId() == checkedId) {
                    energyConsumeText.setText(Math.round(MonthConsumeEnergy )+" Kcal");
                    energyDesireText.setText(Math.round(MonthDesireEnergy)+" Kcal");
                    if(MonthConsumeEnergy<=MonthDesireEnergy){
                        imageView1.setImageResource(R.drawable.thumbup);
                        imageView2.setImageResource(R.drawable.thumbup);
                        imageView3.setImageResource(R.drawable.thumbup);
                    }else{
                        imageView1.setImageResource(R.drawable.thumpdown);
                        imageView2.setImageResource(R.drawable.thumpdown);
                        imageView3.setImageResource(R.drawable.thumpdown);
                    }

                } else if (dayButton.getId() == checkedId) {
                    energyConsumeText.setText(Math.round(DayConsumeEnergy )+" Kcal");
                    energyDesireText.setText(Math.round(DayDesireEnergy )+" Kcal");
                    if(DayConsumeEnergy<=DayDesireEnergy){
                        imageView1.setImageResource(R.drawable.thumbup);
                        imageView2.setImageResource(R.drawable.thumbup);
                        imageView3.setImageResource(R.drawable.thumbup);
                    }else{
                        imageView1.setImageResource(R.drawable.thumpdown);
                        imageView2.setImageResource(R.drawable.thumpdown);
                        imageView3.setImageResource(R.drawable.thumpdown);
                    }
                }
            }
        });

    }
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt(DAY_DATE_KEY_2,dayDate);
        preferencesEditor.putInt(WEEK_DATE_KEY_2,weekDate);
        preferencesEditor.putInt(MONTH_DATE_KEY_2,monthDate);

        preferencesEditor.apply();
    }
}