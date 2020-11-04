package com.example.healthcare;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
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

    @Override
    public void onBackPressed() {
        if (parentLayout.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Exit?")
                    .setMessage("Are you going to exit the app?")
                    .setNegativeButton(android.R.string.no, null)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            MainActivity.super.onBackPressed();
                        }
                    }).create().show();
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
            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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
        }
    }
}