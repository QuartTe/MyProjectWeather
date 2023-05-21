package com.example.myproject.data

import com.example.myproject.data.remote.models.DayInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
    @GET("/forecast")
    fun getWeather():Call<DayInfo>
}