package com.example.myproject.presentation.futuredays

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject.R
import com.example.myproject.presentation.adapters.WeatherAdapter
import com.example.myproject.databinding.FragmentFutureDaysBinding


class FutureDaysFragment : Fragment(R.layout.fragment_future_days) {
    private lateinit var binding: FragmentFutureDaysBinding

    private lateinit var adapter: WeatherAdapter

    private val args: FutureDaysFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFutureDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() = with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        rcView.adapter = adapter

        val forecastWeek = args.weekData
        val forecastList = forecastWeek!!.forecastday

        adapter.setWeather(forecastList)
    }

}