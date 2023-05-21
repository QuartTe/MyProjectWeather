package com.example.myproject.data.response


data class CurrentWeatherResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)