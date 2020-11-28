package com.example.healthcare;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton profileButton;
    ArrayList<Integer> parentLayout = new ArrayList<Integer>();
    ArrayList<String> data = null;
    EditText nameUser, studentID, userHeight, userWeight, userAge;
    Button buttonOne, buttonTwo, saveButton, cancelButton, femaleButton, maleButton;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.quit_settings) {
            MainActivity.this.onBackPressed();
        }

        if (id == R.id.setup_settings) {
            parentLayout.add(R.layout.activity_main);
            changeLayout(R.layout.profile);
        }

        if (id == R.id.reset_settings) {
            data.clear();
            data.add("Name");
            data.add("Student ID");
            data.add("Height");
            data.add("Weight");
            data.add("Age");
            data.add("male");
            saveData();
            TextView view = findViewById(R.id.userName);
            view.setText(data.get(0));
            view = findViewById(R.id.studentIDBox);
            view.setText(data.get(1));
        }

        return super.onOptionsItemSelected(item);
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

            buttonOne = findViewById(R.id.buttonOne);
            buttonOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (data.get(2).equals("Height") || data.get(3).equals("Weight") || data.get(4).equals("Age")){
                        Toast.makeText(MainActivity. this, "Please set up your information first",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Intent intent = new Intent(MainActivity.this, CanteenActivity.class);
                    startActivity(intent);
                }
            });

            buttonTwo = findViewById(R.id.buttonTwo);
            buttonTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (data.get(2).equals("Height") || data.get(3).equals("Weight") || data.get(4).equals("Age")){
                        Toast.makeText(MainActivity. this, "Please set up your information first",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Intent intent = new Intent(MainActivity.this, EnergyActivity.class);
                    startActivity(intent);
                }
            });

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            toolbar.setBackgroundColor(Color.BLACK);
        }

        if ( layout == R.layout.profile) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setBackgroundColor(Color.BLACK);
            toolbar.setTitle("Setup Information");
            toolbar.setNavigationIcon(R.drawable.back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { MainActivity.this.onBackPressed(); }
            });
            nameUser = findViewById(R.id.nameUser);
            studentID = findViewById(R.id.studentID);
            saveButton = findViewById(R.id.saveButtonId);
            cancelButton = findViewById(R.id.cancelButton);
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

            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity. this, "Changes discarded",Toast.LENGTH_SHORT).show();
                    MainActivity.this.onBackPressed();
                }
            });

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
                    if (! userHeight.getText().toString().isEmpty()) data.set(2, userHeight.getText().toString());
                    if (! userWeight.getText().toString().isEmpty()) data.set(3, userWeight.getText().toString());
                    if (! userAge.getText().toString().isEmpty()) data.set(4, userAge.getText().toString());
                    if (! nameUser.getText().toString().isEmpty()) data.set(0, nameUser.getText().toString());
                    if (! studentID.getText().toString().isEmpty()) data.set(1, studentID.getText().toString());
                    saveData();
                    Toast.makeText(MainActivity. this, "Information saved",Toast.LENGTH_SHORT).show();
                    MainActivity.this.onBackPressed();
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