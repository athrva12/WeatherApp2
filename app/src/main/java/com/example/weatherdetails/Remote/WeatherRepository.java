package com.example.weatherdetails.Remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import com.example.weatherdetails.Models.Main;
import com.example.weatherdetails.Models.Weather;
import com.example.weatherdetails.Models.WeatherApi;
import com.example.weatherdetails.ViewModel.WeatherClassViewModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {
    private ApiService apiService;
    final MutableLiveData<List<String>> data = new MutableLiveData<>();
    WeatherApi weatherApi1=new WeatherApi();
    private static class SingletonHelper
    {
        private static final WeatherRepository INSTANCE = new WeatherRepository();
    }
    public static WeatherRepository getInstance()
    {
        return SingletonHelper.INSTANCE;
    }
    public WeatherRepository()
    {

        apiService= RetrofitClass.getAPIService();
    }

    public MutableLiveData<List<String>> getWeatherdata(String city,
                                            String key)
    {
        ArrayList<String>list =new ArrayList<String>();

        apiService.getTicketJSON(city, key)
                .enqueue(new Callback<WeatherApi>()
                {
                    @Override
                    public void onResponse(Call<WeatherApi> call, Response<WeatherApi> response)
                    {
                        if (response.isSuccessful())
                        {

                           list.add(0,response.body().getMain().getPressure().toString());
                           list.add(1,response.body().getMain().getHumidity().toString());
                           list.add(2,response.body().getWind().getSpeed().toString());
                           list.add(3,response.body().getMain().getTemp().toString());
                           list.add(4,response.body().getName());
                           for(int i =0;i<response.body().getWeather().size();i++) {

                               list.add(i+5, response.body().getWeather().get(i).getDescription());
                           }

                            data.setValue(list);
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherApi> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }

}
