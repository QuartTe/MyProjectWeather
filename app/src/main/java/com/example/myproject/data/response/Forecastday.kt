package com.example.myproject.data.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Forecastday(
    val date: String,
    @SerializedName("date_epoch")
    val dateEpoch: Int,
    val day: Day,
    val hour: List<Hour>
):Parcelable