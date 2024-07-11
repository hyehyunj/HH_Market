package com.android.hh_market

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.hh_market.databinding.ActivityMainPageBinding

class MainPageActivity : AppCompatActivity() {


    private lateinit var _binding : ActivityMainPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainPageBinding.inflate(layoutInflater)

        setContentView(_binding.root)

    }
}