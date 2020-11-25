package com.example.healthcare;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class SaveData extends AppCompatActivity {


   /* ArrayList<String> data=new ArrayList<>();

    public SaveData(){
        data.add("144");
        data.add("18");
        data.add("41");
        data.add("6");
        saveData("PORK SOUP KEY",data);
        data.clear();


    }


    public void saveData(String KEY, ArrayList<String> data,) {
        SharedPreferences.Editor editor = mPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(data);
        editor.putString(KEY, json);
        editor.apply();

    }

    public ArrayList<String> loadData(String KEY) {

        Gson gson = new Gson();
        mPreferences= getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        String json = mPreferences.getString(KEY, null);

        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        data = gson.fromJson(json, type);
        if (data == null || data.isEmpty()){
            data = new ArrayList<String>();
            data.add("Energy");
            data.add("Protein");
            data.add("Cholesterol");
            data.add("Fat");
        }
        return data;
    }*/

}
