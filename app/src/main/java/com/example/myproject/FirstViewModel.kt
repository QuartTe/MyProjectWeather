package com.example.myproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myproject.adapters.DayInfo

class FirstViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<DayInfo>()
    val liveDataList = MutableLiveData<List<DayInfo>>()
}