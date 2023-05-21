package com.example.myproject.presentation.first

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.myproject.R
import com.example.myproject.data.response.Forecast
import com.example.myproject.databinding.FragmentFirstBinding



class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var binding: FragmentFirstBinding

    private var TAG = "Here"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weatherViewModel = ViewModelProvider(this).get(FirstViewModel::class.java)

        var weatherForWeek: Forecast? = null

        weatherViewModel.weatherLiveData.observe(viewLifecycleOwner){
            val weather = it
            if(weather==null)
            {
                Toast.makeText(requireContext(), "City not found", Toast.LENGTH_SHORT).show()
                return@observe
            }
            weatherForWeek = weather.forecast
            with(binding) {
                Glide
                    .with(imageWeather.context)
                    .load("https:" + weather.current.condition.icon)
                    .fitCenter()
                    .into(imageWeather)

                Log.d(TAG, weather.current.condition.icon)

                citynameData.text = weather.location.name
                countrynameData.text = weather.location.country
                skyStateData.text = weather.current.condition.text
                tempNowData.text = weather.current.tempC.toString()
                tempMaxData.text = weather.forecast.forecastday[0].day.maxtempC.toString()
                tempMinData.text = weather.forecast.forecastday[0].day.mintempC.toString()
                timeData.text = weather.current.lastUpdated
                humidityData.text = weather.current.humidity.toString()
                precipationData.text = weather.current.precipMm.toString()
                windSpeedData.text = weather.current.windKph.toString()
                visibilityData.text = weather.current.visKm.toString()
                pressureData.text = weather.current.pressureMb.toString()
                windDirectionData.text = weather.current.windDir

            }
        }

        binding= FragmentFirstBinding.bind(view)

        binding.searchBar.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(!query.isNullOrBlank()){
                    weatherViewModel.getWeather(query!!)
                    Log.d(TAG, "SendRequest")
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               return true
            }

        })



        binding.cardView3.setOnClickListener {
            if(weatherForWeek!=null) {
                newFragmentStart(weatherForWeek)
            }
        }
    }


    private fun newFragmentStart(forecast: Forecast?){

        val destination = FirstFragmentDirections.actionFirstFragmentToFutureDaysFragment(forecast)

        findNavController().navigate(destination)
    }
}