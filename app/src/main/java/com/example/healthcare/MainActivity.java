package com.example.healthcare;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton profileButton;
    ArrayList<Integer> parentLayout = new ArrayList<Integer>();
    static String userName = "Name";
    EditText nameUser;
    Button saveButton;

    @Override
    public void onBackPressed() {
        if (parentLayout.isEmpty()) return;
        changeLayout(parentLayout.get(parentLayout.size()-1));
        parentLayout.remove(parentLayout.get(parentLayout.size()-1));
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
            TextView userNameInput = findViewById(R.id.userName);
            userNameInput.setText(userName);
        }
        
        if ( layout == R.layout.profile) {
            nameUser = findViewById(R.id.nameUser);
            saveButton = findViewById(R.id.saveButtonId);
            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.userName = nameUser.getText().toString();
                }
            });
        }

    }
}