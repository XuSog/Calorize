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

    String GoodComment = "good job";
    String BadComment = "need to eat less";

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
    TextView commentText;

    String DayGoodComment = "well done, you have achieved today's target!";
    String DayBadComment = "oh no you did not meet today's target, try harder!";
    String WeekGoodComment = "well done, you have achieved this week's target!";
    String WeekBadComment = "oh no you did not meet this week's target, try harder!";
    String MonthGoodComment = "well done, you have achieved this month's target!";
    String MonthBadComment = "oh no you did not meet this month's target, try harder!";

    public static final String sharedPrefFile = "com.example.android.mainsharedprefs";
    public static SharedPreferences mPreferences;


    public static final String DAY_DATE_KEY_2 = "DAY DATE KEY_2";
    public static final String WEEK_DATE_KEY_2 = "WEEK DATE KEY_2";
    public static final String MONTH_DATE_KEY_2 = "MONTH DATE KEY_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.energy_activity);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setBackgroundColor(Color.BLACK);
        toolbar.setTitle("About Me");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

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
        WeekDesireEnergy = DayDesireEnergy * 7;//当前年份数目
        MonthDesireEnergy = DayDesireEnergy * 30;//当前月份数目

        Log.e("TAG3", DayConsumeEnergy + "");
        energyConsumeText = findViewById(R.id.EnergyConsumeText);
        energyDesireText = findViewById(R.id.EnergyDesireText);

        dateRadioGroup = (RadioGroup) findViewById(R.id.dateRadioGroup);
        dayButton = (RadioButton) findViewById(R.id.dayButton);
        weekButton = (RadioButton) findViewById(R.id.weekButton);
        monthButton = (RadioButton) findViewById(R.id.monthButton);
        commentText = findViewById(R.id.CommentText);

        energyConsumeText.setText(DayConsumeEnergy + "");
        energyDesireText.setText(DayDesireEnergy + "");
        if(DayConsumeEnergy<=DayDesireEnergy){
            commentText.setText( DayGoodComment );
        }else{
            commentText.setText( DayBadComment );
        }
        dateRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (weekButton.getId() == checkedId) {

                    energyConsumeText.setText(WeekConsumeEnergy + "");
                    energyDesireText.setText(WeekDesireEnergy + "");
                    if(WeekConsumeEnergy<=WeekDesireEnergy){
                        commentText.setText( WeekGoodComment );
                    }else{
                        commentText.setText( WeekBadComment );
                    }

                } else if (monthButton.getId() == checkedId) {
                    energyConsumeText.setText(MonthConsumeEnergy + "");
                    energyDesireText.setText(MonthDesireEnergy + "");
                    if(MonthConsumeEnergy<=MonthDesireEnergy){
                        commentText.setText( MonthGoodComment );
                    }else{
                        commentText.setText( MonthBadComment );
                    }

                } else if (dayButton.getId() == checkedId) {
                    energyConsumeText.setText(DayConsumeEnergy + "");
                    energyDesireText.setText(DayDesireEnergy + "");
                    if(DayConsumeEnergy<=DayDesireEnergy){
                        commentText.setText( DayGoodComment );
                    }else{
                        commentText.setText( DayBadComment );
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