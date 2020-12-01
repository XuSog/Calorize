package com.example.healthcare;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.example.healthcare.EnergyActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Plan extends AppCompatActivity {
    TextView run,swim,bicycle,rope_skip;
    double advised_index=0.3;
    double max_index=0.4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan);
        run=findViewById(R.id.run);
        swim=findViewById(R.id.swim);
        bicycle=findViewById(R.id.bicycle);
        rope_skip=findViewById(R.id.rope_skip);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.BLACK);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setTitle("Recommended Workout");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("data list", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        ArrayList<String> data = gson.fromJson(json, type);

        Double weight=Double.valueOf(data.get(2));
        Double height=Double.valueOf(data.get(3));
        Integer age=Integer.valueOf(data.get(4));
        String gender=String.valueOf(data.get(5));

        Double standard_energy=new Get_desire_day_energy(height, weight, age, gender).get_energy();
        double advised_value=advised_index*standard_energy;
        double max_value=max_index*standard_energy;
        run.setText("Run: "+get_run_time(advised_value)+" h");
        swim.setText("Swim: "+get_swim_time(advised_value)+" h");
        bicycle.setText("Bicycle: "+get_bicyle_time(advised_value)+" h");
        rope_skip.setText("Rope_skip: "+get_rope_skip_time(advised_value)+" h");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params.weight = 1.0f;
        params.gravity = Gravity.CENTER;

    }
    private double get_swim_time(double energy){
        return new BigDecimal(energy/447).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    private double get_run_time(double energy){
        return new BigDecimal(energy/650).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    private double get_rope_skip_time(double energy){
        return new BigDecimal(energy/800).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    private double get_bicyle_time(double energy){
        return new BigDecimal(energy/290).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}