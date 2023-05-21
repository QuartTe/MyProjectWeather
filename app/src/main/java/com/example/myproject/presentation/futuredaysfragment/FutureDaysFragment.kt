package com.example.myproject.presentation.futuredaysfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject.R
import com.example.myproject.data.remote.models.DayInfo
import com.example.myproject.presentation.adapters.WeatherAdapter
import com.example.myproject.databinding.FragmentFutureDaysBinding


class FutureDaysFragment : Fragment(R.layout.fragment_future_days) {
    private lateinit var binding: FragmentFutureDaysBinding

    private lateinit var adapter: WeatherAdapter



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

        val list = listOf(
            DayInfo("", "", "10/04/2023",
                "Murky", "", "",
                "18°C", "25°C", "","","","","","",""),

            DayInfo("", "", "11/04/2023",
                "Sunny", "", "",
                "21°C", "26°C", "","","","","","",""),

            DayInfo("", "", "12/04/2023",
                "Sunny", "", "",
                "20°C", "30°C", "","","","","","",""),

            DayInfo("", "", "14/04/2023",
                "Rainy", "", "",
                "17°C", "23°C", "","","","","","","")
        )

        adapter.submitList(list)
    }

   companion object {
        @JvmStatic
        fun newInstance() = FutureDaysFragment()
   }
}