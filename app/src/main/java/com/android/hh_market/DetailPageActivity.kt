package com.android.hh_market

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.android.hh_market.databinding.ActivityDetailPageBinding
import com.android.hh_market.databinding.ActivityMainPageBinding
import com.android.hh_market.databinding.ItemRecyclerviewBinding
import com.google.android.material.appbar.MaterialToolbar

class DetailPageActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "DetailPageActivity" }

    private lateinit var _binding : ActivityDetailPageBinding
    private val productList = Product.getProductData()
    private var position = 0
    val data : Parcelable? = intent.getParcelableExtra("DATA")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(_binding.root)




//        position = intent.getIntExtra("POSITION",0)
//val data = intent.getParcelableExtra<ProductInfo>("DATA")
//        Log.d(TAG, "d ${data?.title}")

with(_binding) {
    ivDetailTitle.setImageResource(productList[position].image)
    tvDetailSeller.setText(productList[position].seller)
    tvDetailLocation.setText(productList[position].location)
    tvDetailTitle.setText(productList[position].title)
    tvDetailIntroduce.setText(productList[position].introduce)
    }


        btnBackListener()
////
//        val intent = Intent(this, MainPageActivity::class.java)
//        finish()



    }

//뒤로가기버튼-like제작중
    private fun btnBackListener() {
        _binding.btnDetailBack.setOnClickListener {
            finish()
//val intent = Intent(this, MainPageActivity::class.java)
//            intent.putExtra("LIKE",productList[position].like)
//            startActivity(intent)
        }
    }

    //like버튼-제작중
        private fun cbLikeListener() {
            _binding.cbDetailLike.setOnCheckedChangeListener { it, ischecked ->
                if (it.isChecked)
                    productList[position].like++

            }
            }

}