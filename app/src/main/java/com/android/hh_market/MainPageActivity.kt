package com.android.hh_market

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.hh_market.databinding.ActivityMainPageBinding

class MainPageActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityMainPageBinding
    private val productList = Product.getProductData()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        getAdapter()

    }


private fun getAdapter() {
    val adapter = Adapter(productList)
    _binding.mainRecyclerView.adapter = adapter
    _binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
}


}

