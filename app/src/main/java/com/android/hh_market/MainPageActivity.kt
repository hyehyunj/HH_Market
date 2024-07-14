package com.android.hh_market

import android.content.Intent
import android.os.Bundle
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.hh_market.databinding.ActivityMainPageBinding

class MainPageActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainPageBinding
    private val productList = Product.getProductData()
    private val adapter = Adapter(productList)
    companion object {
        private const val TAG = "MainPageActivity" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        getAdapter()


        val intent = Intent(this, DetailPageActivity::class.java)
        Log.d(TAG, "bbb")

        adapter.itemClick = object : Adapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                intent.putExtra("data",position)
                startActivity(intent)

            }
        }

    }


    private fun getAdapter() {
        _binding.mainRecyclerView.adapter = adapter
        _binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)


    }
private fun click() {

}
}

