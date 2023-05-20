package com.example.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myproject.databinding.ActivityMainBinding
import com.example.myproject.fragments.FirstFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction().replace(R.id.act_main,FirstFragment.newInstance())
            .commit()
    }
}