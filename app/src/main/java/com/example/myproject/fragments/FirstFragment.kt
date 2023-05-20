package com.example.myproject.fragments

import android.Manifest
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.Navigation
import com.example.myproject.FirstViewModel
import com.example.myproject.R
import com.example.myproject.adapters.WeatherAdapter
import com.example.myproject.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var pLauncher: ActivityResultLauncher<String>
    private lateinit var binding: FragmentFirstBinding


    private lateinit var viewModel: FirstViewModel



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

        binding= FragmentFirstBinding.bind(view)

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

    private fun newFragmentStart(){

        val destination = FirstFragmentDirections.actionFirstFragmentToFutureDaysFragment()

        findNavController().navigate(destination)
    }



    companion object{
        @JvmStatic
        fun newInstance()=FirstFragment()
    }

}