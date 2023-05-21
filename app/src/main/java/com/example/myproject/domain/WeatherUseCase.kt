package com.example.myproject.domain

import com.example.myproject.data.response.CurrentWeatherResponse
import com.example.myproject.data.repository.WeatherRepo

object WeatherUseCase {
    suspend fun getWeather(cityName: String): CurrentWeatherResponse {
        return WeatherRepo.getWeather(cityName)
    }
}