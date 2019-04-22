package com.example.weatherdetails.Models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class RetrofitResponse<T> {

    @Embedded
    @SerializedName("data")
    @Expose
    private T data;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}