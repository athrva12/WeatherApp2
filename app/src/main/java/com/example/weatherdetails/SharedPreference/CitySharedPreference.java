package com.example.weatherdetails.SharedPreference;
import android.content.Context;
import android.content.SharedPreferences;

import java.security.KeyStore;

public class CitySharedPreference {
   private SharedPreferences sharedPreferences;
   private SharedPreferences.Editor editor;
   private Context context;
    private static final String PREF_NAME = "weather";
    private int PRIVATE_MODE = 0;


    public CitySharedPreference(Context context) {
        this.context = context;

        sharedPreferences =this.context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=sharedPreferences.edit();
    }
    public void setdate(int date)
    {
        editor.putInt("date",date);
        editor.commit();
    }
    public int getdate()
    {
        return sharedPreferences.getInt("date",0);
    }
    public void setSavedCityName(String Cityname) {
        editor.putString("City_Name", Cityname);
        editor.commit();
    }
    public String getSavedCityName() {
        return sharedPreferences.getString("City_Name", "");
    }


    public String getSavedCityPressure() {
        return sharedPreferences.getString("City_Pressure", "d");
    }
    public void setCityPressure(String Temp) {
        editor.putString("City_Pressure", Temp);
        editor.commit();
    }


    public String getSavedCityHumidity() {
        return sharedPreferences.getString("City_Humidity", "");
    }
    public void setCityHumidity(String Temp) {
        editor.putString("City_Humidity", Temp);
        editor.commit();
    }

    public void setCityTemp(String Temp) {
        editor.putString("City_Temp", Temp);
        editor.commit();
    }

    //retrieve username frome pref
    public String getSavedCityTemp() {
        return sharedPreferences.getString("City_Temp", "");
    }
    public void setWindSpeed(String userName) {
        editor.putString("City_Wind", userName);
        editor.commit();
    }

    //retrieve username frome pref
    public String getSavedWindSpeed() {
        return sharedPreferences.getString("City_Wind", "");
    }
    public void setWeatherDescription(String userName) {
        editor.putString("City_Description", userName);
        editor.commit();
    }

    //retrieve username frome pref
    public String getWeatherDescription() {
        return sharedPreferences.getString("City_Description", "");
    }
}
