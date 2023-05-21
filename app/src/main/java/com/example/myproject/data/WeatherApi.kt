package com.example.myproject.data

import com.example.myproject.data.response.CurrentWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
    @GET("forecast.json")
    suspend fun getWeather(
        @Query("key") key: String = "74ca78bee68d44d0890194829231805",
        @Query("q") location: String,
        @Query("days") daysNum: String = "7",
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no",
    ): CurrentWeatherResponse

}