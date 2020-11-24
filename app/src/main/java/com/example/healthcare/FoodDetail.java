package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FoodDetail extends AppCompatActivity {

    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;
    Button cancelButton;
    Button saveButton;
    TextView name;
    String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detail);
        data = getData();
        name = findViewById(R.id.name);
        name.setText(data[0]);
        cancelButton = findViewById(R.id.cancelButtonFD);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        saveButton = findViewById(R.id.saveButtonFD);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                Toast.makeText(FoodDetail.this, data[0] + " Selected",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        barChart = findViewById(R.id.BarChart);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setLabelCount(4, true);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setValueFormatter(new MyXAxisFormatter());
        YAxis yAxis = barChart.getAxisLeft();
        yAxis.setTextSize(10f);
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(150f);
        yAxis.setGranularity(150f);
        yAxis.setLabelCount(7, true);
        yAxis.setTextColor(Color.WHITE);
        Legend legend = barChart.getLegend();
        legend.setEnabled(false);

        getEntries();
        barDataSet = new BarDataSet(barEntries, "Nutrients");
        barDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        barDataSet.setValueTextColor(Color.WHITE);
        barDataSet.setValueTextSize(18f);

        barData = new BarData(barDataSet);
        barChart.setData(barData);
        // disable description
        Description description = barChart.getDescription();
        description.setEnabled(false);
        barChart.setDescription(description);
        barChart.animateY(1200);
    }

    private void getEntries() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1.5f, Integer.valueOf(data[1])));
        barEntries.add(new BarEntry(3f, Integer.valueOf(data[2])));
        barEntries.add(new BarEntry(4.5f, Integer.valueOf(data[3])));
        barEntries.add(new BarEntry(6f, Integer.valueOf(data[4])));
    }

    class MyXAxisFormatter implements IAxisValueFormatter{
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            if (value <= 2f) return "Energy";
            if (value <= 4f) return "Protein";
            if (value <= 5f) return "Cholesterol";
            return "Fat";
        }
    }

    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("food data", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        ArrayList<String> foodData = gson.fromJson(json, type);
        foodData.add(String.valueOf(Calendar.getInstance().getTime()));
        foodData.add(data[1]);
        json = gson.toJson(foodData);
        editor.putString("food data", json);
        editor.apply();
    }

    // to be implemented
    private String[] getData(){
        Intent intent = getIntent();
        List<String> dataGet = intent.getStringArrayListExtra(HealthySoupActivity.KEY);
        String[] foodDetail = dataGet.toArray(new String[0]);  //to be replaced with actual value
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("data list", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        ArrayList<String> data = gson.fromJson(json, type);
        User user = new User(Double.valueOf(data.get(2)),Double.valueOf(data.get(3)), data.get(5),Integer.valueOf(data.get(4)));
        String[] dataAdvised = user.advise();
        for (String i: dataAdvised){
            System.out.println(i);
        }
        String[] dataString = new String[5];
        dataString[0] = foodDetail[0];
        dataString[1] = String.valueOf(Integer.valueOf((int) (Double.valueOf(foodDetail[1])*100/Double.valueOf(dataAdvised[0]))));
        dataString[2] = String.valueOf(Integer.valueOf((int) (Double.valueOf(foodDetail[2])*100/Double.valueOf(dataAdvised[1]))));
        dataString[3] = String.valueOf(Integer.valueOf((int) (Double.valueOf(foodDetail[3])*100/Double.valueOf(dataAdvised[2]))));
        dataString[4] = String.valueOf(Integer.valueOf((int) (Double.valueOf(foodDetail[4])*100/Double.valueOf(dataAdvised[3]))));
        for (String i: dataString){
            System.out.println(i);
        }
        return dataString;
    }


    class User {
        private double height,weight;
        private String sex;
        private int year;
        User(double height,double weight,String sex,int year){
            this.height=height;
            this.weight=weight;
            this.sex=sex;
            this.year=year;

        }
        public String[] advise(){
            String[] result=new String[4];
            BigDecimal energy,protein,cholesterol,fat;

            if (this.sex=="male"){
                energy=new BigDecimal(66+13.7*this.weight+5*this.height-6.8*year);
                protein=new BigDecimal(1.1*this.weight);
            }else{
                energy=new BigDecimal(655+9.6*this.weight+1.8*this.height-4.7*year);
                protein=new BigDecimal(0.9*this.weight);
            }
            cholesterol=new BigDecimal(600);
            fat=energy.multiply(new BigDecimal(0.25*0.111));
            result[0]=energy.toString().substring(0,6);
            result[1]=protein.toString();
            result[2]=cholesterol.toString();
            result[3]=fat.toString().substring(0,4);
            return result;
        }

    }

}