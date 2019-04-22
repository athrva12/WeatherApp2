package com.example.weatherdetails.ViewModel;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.weatherdetails.MainActivity;
import com.example.weatherdetails.R;
import com.example.weatherdetails.ResultActivity;
import com.example.weatherdetails.SharedPreference.CitySharedPreference;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        String datetime = dateformat.format(calendar.getTime());
        String da= datetime.substring(0,2);
        int current_date=Integer.valueOf(da);


        CitySharedPreference citySharedPreference = new CitySharedPreference(this);

        if(citySharedPreference.getSavedCityName().isEmpty()||citySharedPreference.getdate()!=current_date)
        {
            if(!citySharedPreference.getSavedCityName().isEmpty())
            {
                citySharedPreference.setSavedCityName("");
            }
            citySharedPreference.setdate(current_date);
            Intent i = new Intent(getApplication(), MainActivity.class);
            startActivity(i);
            finish();

        }else {
            Intent i = new Intent(getApplication(), ResultActivity.class);
            startActivity(i);
            finish();
        }
    }
}
