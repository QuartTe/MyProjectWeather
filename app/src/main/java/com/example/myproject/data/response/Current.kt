package com.example.myproject.data.response


import com.google.gson.annotations.SerializedName

data class Current(
    val condition: Condition,
    val humidity: Int,
    @SerializedName("is_day")
    val isDay: Int,
    @SerializedName("precip_mm")
    val precipMm: Double,
    @SerializedName("pressure_mb")
    val pressureMb: Double,
    @SerializedName("temp_c")
    val tempC: Double,
    @SerializedName("vis_km")
    val visKm: Double,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_kph")
    val windKph: Double,
    @SerializedName("last_updated")
    val lastUpdated: String,
)