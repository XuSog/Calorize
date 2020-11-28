package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class EnergyActivity extends AppCompatActivity {

    Double DayConsumeEnergy;
    Double WeekConsumeEnergy;
    Double MonthConsumeEnergy;
    String InputEnergy;

    Double DayDesireEnergy;
    Double WeekDesireEnergy;
    Double MonthDesireEnergy;


    String GoodComment="good job";
    String BadComment="need to eat less";

    String height;
    String weight;
    String age;
    String gender;


    RadioGroup dateRadioGroup ;
    RadioButton dayButton;
    RadioButton weekButton;
    RadioButton monthButton;
    TextView energyConsumeText;
    TextView energyDesireText;
    TextView commentText;

    public static final String sharedPrefFile = "com.example.android.mainsharedprefs";
    public static SharedPreferences mPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.energy_activity);

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
        for (String i: data){
            System.out.println(i);
        }

        weight=data.get(2);
        height=data.get(3);
        age=data.get(4);
        gender=data.get(5);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        if(mPreferences!=null){

            DayConsumeEnergy=Double.valueOf(mPreferences.getString(FoodDetail.DAY_ENERGY_KEY,"0"));
            WeekConsumeEnergy=Double.valueOf(mPreferences.getString(FoodDetail.WEEK_ENERGY_KEY,"0"));
            MonthConsumeEnergy=Double.valueOf(mPreferences.getString(FoodDetail.MONTH_ENERGY_KEY,"0"));

        }else{

            DayConsumeEnergy=0.0;
            WeekConsumeEnergy=0.0;
            MonthDesireEnergy=0.0;
        }

        DayDesireEnergy=new Get_desire_day_energy(Double.valueOf(height),Double.valueOf(weight),Integer.valueOf(age),gender).get_energy();
        WeekDesireEnergy=DayDesireEnergy*365;//当前年份数目
        MonthDesireEnergy=DayDesireEnergy*30;//当前月份数目

        Log.e("TAG3",DayConsumeEnergy+"");
        energyConsumeText=findViewById(R.id.EnergyConsumeText);
        energyDesireText=findViewById(R.id.EnergyDesireText);

        dateRadioGroup=(RadioGroup)findViewById(R.id.dateRadioGroup);
        dayButton=(RadioButton) findViewById(R.id.dayButton);
        weekButton=(RadioButton) findViewById(R.id.weekButton);
        monthButton=(RadioButton) findViewById(R.id.monthButton);

        dateRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (weekButton.getId() == checkedId) {
                    energyConsumeText.setText(WeekConsumeEnergy+"");
                    energyDesireText.setText(WeekDesireEnergy+"");
                } else if (monthButton.getId() == checkedId) {
                    energyConsumeText.setText(MonthConsumeEnergy+"");
                    energyDesireText.setText(MonthDesireEnergy+"");
                }else if(dayButton.getId()==checkedId){
                    energyConsumeText.setText(DayConsumeEnergy+"");
                    energyDesireText.setText(DayDesireEnergy+"");
                }
            }
        });


    }
}