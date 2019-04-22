package com.example.weatherdetails.Remote;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

//import com.viewmodelclassvideoexample.model.Ticket;

import com.example.weatherdetails.Models.Weather;
import com.example.weatherdetails.Models.WeatherApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class RetrofitClass {
    public static final String BaseUrl ="http://api.openweathermap.org/data/2.5/";

    private static Retrofit getRetroInstance()
    {

        return new Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static ApiService getAPIService()
    {

        return getRetroInstance().create(ApiService.class);

    }



}
