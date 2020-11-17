package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
import java.util.ArrayList;

public class FoodDetail extends AppCompatActivity {

    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detail);
        cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        barEntries.add(new BarEntry(1.5f, 2));
        barEntries.add(new BarEntry(3f, 1));
        barEntries.add(new BarEntry(4.5f, 5));
        barEntries.add(new BarEntry(6f, 3));
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
}