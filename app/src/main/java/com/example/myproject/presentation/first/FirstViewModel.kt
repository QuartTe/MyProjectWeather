package com.example.myproject.presentation.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myproject.data.response.CurrentWeatherResponse
import com.example.myproject.domain.WeatherUseCase
import kotlinx.coroutines.launch

class FirstViewModel : ViewModel() {
    val weatherLiveData = MutableLiveData<CurrentWeatherResponse?>()

    init {
        getWeather("Kiev")
    }

    fun getWeather(cityName: String){

        viewModelScope.launch {
            try {
                val weather = WeatherUseCase.getWeather(cityName)
                weatherLiveData.postValue(weather)
            }catch(exception: Exception){
                weatherLiveData.postValue(null)
            }
        }
    }
}