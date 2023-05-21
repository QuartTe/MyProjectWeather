package com.example.myproject.data.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Condition(
    val code: Int,
    val icon: String,
    val text: String
):Parcelable