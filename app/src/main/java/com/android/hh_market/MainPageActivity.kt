package com.android.hh_market

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.hh_market.databinding.ActivityMainPageBinding

class MainPageActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityMainPageBinding
    private val dataList = mutableListOf<ProductInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val productList = Product.getProductData()
        _binding = ActivityMainPageBinding.inflate(layoutInflater)

        setContentView(_binding.root)

setLayout()
        marketAdapter()

    }
private fun setLayout() {
    val ProductData = mutableListOf<ProductInfo>()


}
private fun marketAdapter() {
    val adapter = Adapter()
    _binding.mainRecyclerView.adapter = adapter
    _binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
}


}

