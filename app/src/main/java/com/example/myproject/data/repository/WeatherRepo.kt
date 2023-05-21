package com.example.myproject.data.repository

import com.example.myproject.data.WeatherApiFactory
import com.example.myproject.data.response.CurrentWeatherResponse


object WeatherRepo {
    suspend fun getWeather(cityName: String): CurrentWeatherResponse {

        val api = WeatherApiFactory.weathApi
        val weather = api.getWeather(location = cityName)
        return weather
    }
}