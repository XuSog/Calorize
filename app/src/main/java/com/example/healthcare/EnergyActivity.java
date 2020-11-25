/*package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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


        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        if(mPreferences!=null){
            weight=mPreferences.getString(ProfileActivity.WEIGHT_KEY,"60");
            height=mPreferences.getString(ProfileActivity.HEIGHT_KEY,"172");
            age=mPreferences.getString(ProfileActivity.AGE_KEY,"20");
            gender=mPreferences.getString(ProfileActivity.GENDER_KEY,"male");

            DayConsumeEnergy=Double.valueOf(mPreferences.getString(FoodDetailActivity.DAY_ENERGY_KEY,"0"));
            WeekConsumeEnergy=Double.valueOf(mPreferences.getString(FoodDetailActivity.WEEK_ENERGY_KEY,"0"));
            MonthConsumeEnergy=Double.valueOf(mPreferences.getString(FoodDetailActivity.MONTH_ENERGY_KEY,"0"));

        }else{
            weight="60";
            height="172";
            age="20";
            gender="male";

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
}*/