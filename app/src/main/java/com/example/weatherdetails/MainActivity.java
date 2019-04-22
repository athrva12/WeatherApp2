package com.example.weatherdetails;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherdetails.Models.WeatherApi;
import com.example.weatherdetails.Remote.ApiService;
import com.example.weatherdetails.SharedPreference.CitySharedPreference;
import com.example.weatherdetails.ViewModel.WeatherClassViewModel;

import java.util.ArrayList;
import java.util.Calendar;

import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    WeatherClassViewModel weatherClassViewModel;
    TextView textView;

    EditText cityname;
     public String city;
     public  String cityid;
     Button submit_button;
     ArrayList<String>value= new ArrayList<>();
    public  String description=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityname = (EditText) findViewById(R.id.edittext_cityname);
        submit_button = (Button) findViewById(R.id.submit_button);


        weatherClassViewModel = ViewModelProviders.of(this).get(WeatherClassViewModel.class);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city=cityname.getText().toString();



                observeViewModel(weatherClassViewModel,city);
                weatherClassViewModel.getWeatherObservable(city);
                Toast.makeText(getApplicationContext(),"please click again or check the city name",Toast.LENGTH_LONG).show();
                CitySharedPreference sha= new CitySharedPreference(getApplicationContext());

                if(!sha.getSavedCityName().isEmpty()) {
                    Intent i = new Intent(getApplication(), ResultActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }

        private void observeViewModel(WeatherClassViewModel weatherClassViewModel, String city)
        {
            weatherClassViewModel.getWeatherObservable(city)
                    .observe(this,wetherresponse->{
                        if(wetherresponse!=null) {
                            if (wetherresponse.size() != 0) {
                                for (int i = 0; i < wetherresponse.size(); i++) {
                                    value.add(i, wetherresponse.get(i));
                                }
                                description = value.get(wetherresponse.size() - 2) + " " + value.get(wetherresponse.size() - 1);

                            }
                            //saving data in sharedpreference
                            CitySharedPreference sharedPreference = new CitySharedPreference(this);
                            sharedPreference.setCityPressure(value.get(0));
                            //    Toast.makeText(this,sharedPreference.getSavedCityPressure(),Toast.LENGTH_LONG).show();
                            sharedPreference.setCityHumidity(value.get(1));
                            sharedPreference.setWindSpeed(value.get(2));
                            sharedPreference.setCityTemp(value.get(3));
                            sharedPreference.setSavedCityName(value.get(4));
                            sharedPreference.setWeatherDescription(description);
                        }
                    });
        }


    }




