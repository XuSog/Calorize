package com.example.healthcare;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton profileButton;
    ArrayList<Integer> parentLayout = new ArrayList<Integer>();
    ArrayList<String> data = null;
    EditText nameUser;
    EditText studentID;
    Button saveButton;
    Button femaleButton;
    Button maleButton;
    EditText userHeight;
    EditText userWeight;
    EditText userAge;

    @Override
    public void onBackPressed() {
        if (parentLayout.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Exit?")
                    .setMessage("Are you going to exit the app?")
                    .setNegativeButton(android.R.string.no, null)
                    .setPositiveButton(android.R.string.yes, (arg0, arg1) -> MainActivity.super.onBackPressed()).create().show();
        }
        else {
            changeLayout(parentLayout.get(parentLayout.size() - 1));
            parentLayout.remove(parentLayout.get(parentLayout.size() - 1));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Calorize");
        changeLayout(R.layout.activity_main);
    }

    protected void changeLayout(int layout){
        setContentView(layout);
        if (layout == R.layout.activity_main) {
            profileButton = findViewById(R.id.profilePic);
            profileButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    parentLayout.add(R.layout.activity_main);
                    changeLayout(R.layout.profile);
                }
            });
            loadData();
            TextView view = findViewById(R.id.userName);
            view.setText(data.get(0));
            view = findViewById(R.id.studentIDBox);
            view.setText(data.get(1));

        }

        if ( layout == R.layout.profile) {
            nameUser = findViewById(R.id.nameUser);
            studentID = findViewById(R.id.studentID);
            saveButton = findViewById(R.id.saveButtonId);
            userHeight = findViewById(R.id.userHeight);
            userWeight = findViewById(R.id.userWeight);
            femaleButton = findViewById(R.id.femaleButton);
            maleButton = findViewById(R.id.maleButton);
            userAge = findViewById(R.id.userAge);
            final String[] gender = {"male"};

            if (!data.get(0).equals("Name")) nameUser.setText(data.get(0));
            if (!data.get(1).equals("Student ID")) studentID.setText(data.get(1));
            if (!data.get(2).equals("Height")) userHeight.setText(data.get(2));
            if (!data.get(3).equals("Weight")) userWeight.setText(data.get(3));
            if (!data.get(4).equals("Age")) userAge.setText(data.get(4));
            if (!data.get(5).equals(gender[0])) {
                femaleButton.setTextColor(Color.RED);
                maleButton.setTextColor(Color.BLACK);
            }
            else {
                maleButton.setTextColor(Color.RED);
                femaleButton.setTextColor(Color.BLACK);
            }

            femaleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    femaleButton.setTextColor(Color.RED);
                    maleButton.setTextColor(Color.BLACK);
                    gender[0] = "female";
                }
            });

            maleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    maleButton.setTextColor(Color.RED);
                    femaleButton.setTextColor(Color.BLACK);
                    gender[0] = "male";
                }
            });

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.set(5,gender[0]);
                    if (! userHeight.getText().toString().isEmpty()) {
                        try{
                            int height = Integer.parseInt(userHeight.getText().toString());
                            if (height <= 0) throw new Exception();
                            data.set(2, userHeight.getText().toString());
                        }
                        catch (Exception e){
                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("Wrong Format")
                                    .setMessage("Your height should be a positive integer.")
                                    .setPositiveButton(android.R.string.yes, (arg0, arg1) -> userHeight.setText(data.get(2))).create().show();
                        }
                    }
                    if (! userWeight.getText().toString().isEmpty()) {
                        try{
                            int weight = Integer.parseInt(userWeight.getText().toString());
                            if (weight <= 0) throw new Exception();
                            data.set(3, userWeight.getText().toString());
                        }
                        catch (Exception e){
                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("Wrong Format")
                                    .setMessage("Your weight should be a positive integer.")
                                    .setPositiveButton(android.R.string.yes, (arg0, arg1) -> userWeight.setText(data.get(3))).create().show();
                        }
                    }
                    if (! userAge.getText().toString().isEmpty()) {
                        try{
                            int age = Integer.parseInt(userAge.getText().toString());
                            if (age <= 0 || age > 150) throw new Exception();
                            data.set(4, userAge.getText().toString());
                        }
                        catch (Exception e){
                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("Wrong Format")
                                    .setMessage("Your age should be a positive integer between 1 to 150.")
                                    .setPositiveButton(android.R.string.yes, (arg0, arg1) -> userAge.setText(data.get(4))).create().show();
                        }
                    }
                    if (! nameUser.getText().toString().isEmpty()) {
                        data.set(0, nameUser.getText().toString());
                    }
                    if (! studentID.getText().toString().isEmpty()) {
                        data.set(1, studentID.getText().toString());
                    }
                    saveData();
                }
            });
        }

    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(data);
        editor.putString("data list", json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("data list", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        data = gson.fromJson(json, type);

        if (data == null || data.isEmpty()) {
            data = new ArrayList<String>();
            data.add("Name");
            data.add("Student ID");
            data.add("Height");
            data.add("Weight");
            data.add("Age");
            data.add("male");
        }
    }
}