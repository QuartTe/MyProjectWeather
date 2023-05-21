package com.example.myproject.presentation.firstfragment

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.myproject.R
import com.example.myproject.data.WeatherApi
import com.example.myproject.data.WeatherApiFactory
import com.example.myproject.data.remote.models.DayInfo
import com.example.myproject.databinding.FragmentFirstBinding
import com.example.myproject.isPermissionGranted
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory


const val API_KEY = "74ca78bee68d44d0890194829231805"

class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var pLauncher: ActivityResultLauncher<String>
    private lateinit var binding: FragmentFirstBinding

    private val BASE_URL = "http://api.weatherapi.com/v1"

    private lateinit var viewModel: FirstViewModel

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
        checkPermission()

        requestWeatherData("Madrid")

        binding= FragmentFirstBinding.bind(view)

       // getCurrentWeather()

        binding.cardView3.setOnClickListener {
            newFragmentStart()
        }
    }

    private fun permissionListener(){
        pLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()){
            Toast.makeText(activity, "Permission is $it", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkPermission() {
        if (!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)){
            permissionListener()
            pLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

   private fun getCurrentWeather(){

        val api  = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getWeather().awaitResponse()
            if(response.isSuccessful) {
                val data = response.body()!!

                withContext(Dispatchers.Main){
                    binding.citynameData.text = data.cityName
                    binding.countrynameData.text = data.countryName
                    binding.timeData.text = data.time
                    binding.tempNowData.text = data.nowTempC + "°C"
                    binding.tempMaxData.text = data.maxTempC + "°C"
                    binding.tempMinData.text = data.minTempC + "°C"
                    binding.skyStateData.text = data.skyState
                    binding.humidityData.text = data.humidity
                    binding.precipationData.text = data.precipitationMM
                    binding.pressureData.text = data.pressureMB
                    binding.windSpeedData.text = data.windSpeedKPH
                    binding.windDirectionData.text = data.windDirection
                    binding.visibilityData.text = data.visibilityKM

                    }


                }
            }
        }
    }




    private fun requestWeatherData(city: String){
        val url = "https://api.weatherapi.com/v1/forecast.json?key=" +
                API_KEY +
                "&q=" +
                city +
                "&days=" +
                "7" +
                "&aqi=no&alerts=no"
        val queue = Volley.newRequestQueue(context)

        val request = StringRequest(
            Request.Method.GET,
            url,
            {
                result -> Log.d("RequestLog","Result: $result")
            },
            {
                error -> Log.d("RequestLog","Error: $error")
            }
        )

        queue.add(request)
    }



  /*  private fun parseWeatherData(result: String){
        val mainObject = JSONObject(result)
        val item = DayInfo(
            mainObject.
        )
    }
*/
    private fun newFragmentStart(){

        val destination = FirstFragmentDirections.actionFirstFragmentToFutureDaysFragment()

        findNavController().navigate(destination)
    }



    companion object{
        @JvmStatic
        fun newInstance()= FirstFragment()
    }

}