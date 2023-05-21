package com.example.myproject.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myproject.R
import com.example.myproject.databinding.DayItemBinding
import com.example.myproject.data.response.Forecastday

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.Holder>(){

    private var weatherWeek = ArrayList<Forecastday>()

    class Holder(view: View) : RecyclerView.ViewHolder(view){
        val binding = DayItemBinding.bind(view)

        fun bind(item: Forecastday) = with(binding){
            dateDayFr.text = item.date
            skyStateFr.text = item.day.condition.text
            maxTempFr.text = item.day.maxtempC.toString()
            minTempFr.text = item.day.mintempC.toString()
            Glide
                .with(skyStateImageFr.context)
                .load("https:" + item.day.condition.icon)
                .fitCenter()
                .into(skyStateImageFr)
        }
    }


    fun setWeather(weatherWeek:List<Forecastday>){
        this.weatherWeek.clear()
        this.weatherWeek = ArrayList(weatherWeek)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return weatherWeek.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(weatherWeek[position])
    }
}