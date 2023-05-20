package com.example.myproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.R
import com.example.myproject.databinding.DayItemBinding

class WeatherAdapter : ListAdapter<DayInfo, WeatherAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view){
        val binding = DayItemBinding.bind(view)

        fun bind(item: DayInfo) = with(binding){
            dateDayFr.text = item.time
            skyStateFr.text = item.skyState
            maxTempFr.text = item.maxTempC
            minTempFr.text = item.minTempC
        }
    }

    class Comparator : DiffUtil.ItemCallback<DayInfo>(){
        override fun areItemsTheSame(oldItem: DayInfo, newItem: DayInfo): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DayInfo, newItem: DayInfo): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}