package com.example.weatherdetails.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.weatherdetails.Models.WeatherApi;
import com.example.weatherdetails.Remote.RetrofitClass;
import com.example.weatherdetails.Remote.WeatherRepository;

import java.util.List;


public class WeatherClassViewModel extends AndroidViewModel{
    public LiveData<List<String>>newsResponseObservable;
    public WeatherRepository weatherRepository;
    public static final String key="fe7c73ba5cb9de640997cf89222441b9";


    public static final MutableLiveData MUTABLE_LIVE_DATA = new MutableLiveData();
    {
        MUTABLE_LIVE_DATA.setValue(null);
    }

    public WeatherClassViewModel( @NonNull Application application) {
        super(application);

        ;
    }
    public LiveData<List<String>> getWeatherObservable(String city)
    {

        newsResponseObservable = weatherRepository.getInstance()
                .getWeatherdata(city,key);
        return newsResponseObservable;
    }

}