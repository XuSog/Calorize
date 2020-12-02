package com.example.healthcare;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;
import static com.example.healthcare.MainActivity.date;

public class Data {
    static int using_app_days_data=0;
    static ArrayList<String> unlocked_medal_list_data=new ArrayList<>();
    static ArrayList<String> unlocked_photo_list_data=new ArrayList<>();
    static Date date_0_data;
    static int first_use=1;
    static void add_days(){using_app_days_data=using_app_days_data+1;}
    static void update_date_data(Date date){date_0_data=date;}

    static Date get_Date(){
        return date;
    }

    static void check_status_for_medal_and_photo(){

        Date date_0;
        date_0=new java.util.Date();

        if(Data.first_use==0){

            if (true){
                Data.add_days();
                Data.update_date_data(date_0);
            }
            /*
            plz change this into:
            if (date_0.toString().substring(0,7).equals(Data.date_0_data.toString().substring(0,7))){
                Data.add_days();
                Data.update_date_data(date_0);
            }

             */
        }
        if (Data.first_use==1){
            Data.date_0_data=Data.get_Date();
            Data.first_use=0;
            Data.add_days();
        }

        if (Data.using_app_days_data>=1){
            Data.unlocked_medal_list_data.add("one_day_medal" );
            Data.unlocked_photo_list_data.add("0");
        }

        if (Data.using_app_days_data>=3){
            Data.unlocked_medal_list_data.add("three_day_medal");
            Data.unlocked_photo_list_data.add("1");
        }

        if (Data.using_app_days_data>=7){
            Data.unlocked_medal_list_data.add("seven_day_medal");
            Data.unlocked_photo_list_data.add("20");
        }

        if (Data.using_app_days_data>=30){
            Data.unlocked_medal_list_data.add("one_month_medal");
            Data.unlocked_photo_list_data.add("21");
        }
    }

}

