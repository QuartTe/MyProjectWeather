package com.example.myproject.presentation.firstfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myproject.data.remote.models.DayInfo

class FirstViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<DayInfo>()
    val liveDataList = MutableLiveData<List<DayInfo>>()
}