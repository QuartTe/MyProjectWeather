package com.example.myproject.data.remote.models

data class DayInfo(
    val cityName:String,
    val countryName:String,
    val time: String,
    val skyState: String,
    val skyStateIconUrl: String,
    val nowTempC: String,
    val minTempC: String,
    val maxTempC: String,
    val humidity: String,
    val visibilityKM: String,
    val windSpeedKPH: String,
    val windDirection: String,
    val pressureMB: String,
    val precipitationMM: String,
    val hours: String
)
