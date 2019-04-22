package com.example.weatherdetails;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.weatherdetails.Adapter.RecyclerViewAdapter;
import com.example.weatherdetails.SharedPreference.CitySharedPreference;
import com.example.weatherdetails.ViewModel.WeatherClassViewModel;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    WeatherClassViewModel weatherClassViewModel;
    ArrayList<String> variable=new ArrayList<String>(),data=new ArrayList<String>();
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        recyclerView = (RecyclerView) findViewById(R.id.recylerview_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CitySharedPreference sharedPreference=new CitySharedPreference(this);
        data.add(0,sharedPreference.getSavedCityName().toString());
        data.add(1,sharedPreference.getSavedWindSpeed());
        data.add(2,sharedPreference.getSavedCityTemp());
        data.add(3,sharedPreference.getSavedCityPressure());
        data.add(4,sharedPreference.getSavedCityHumidity());
        data.add(5,sharedPreference.getWeatherDescription());
        variable.add(0,"City Name :");
        variable.add(1,"Wind Speed :");
        variable.add(2,"City Tempearature :");
        variable.add(3,"City Pressure :");
        variable.add(4,"City Humidity :");
        variable.add(5,"Weather Description :");
        recyclerViewAdapter= new RecyclerViewAdapter(variable,data);
        recyclerView.setAdapter(recyclerViewAdapter);

    }


    //backpress handle
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();

            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
