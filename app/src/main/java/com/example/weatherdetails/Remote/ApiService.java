package com.example.weatherdetails.Remote;

import com.example.weatherdetails.Models.WeatherApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("weather?")
    Call<WeatherApi> getTicketJSON(@Query("q") String name,@Query("appid")String key);
}
