package com.android.hh_market

import android.app.Activity
import android.content.Intent
import android.icu.text.DecimalFormat
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val productData = intent.getParcelableExtra<ProductInfo>("DATA")
        val dec = DecimalFormat("#,###원")

with(_binding) {
    ivDetailTitle.setImageResource(productData!!.image)
    tvDetailSeller.text = productData.seller
    tvDetailLocation.text = productData.location
    tvDetailTitle.text = productData.title
    tvDetailIntroduce.text = productData.introduce
    tvDetailPrice.text = dec.format(productData.price)
    ivDetailLevel.setImageResource(productData.levelImage)
    tvDetailLevel.text = productData.level
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
//        private fun cbLikeListener() {
//            _binding.cbDetailLike.setOnCheckedChangeListener { it, ischecked ->
//                if (it.isChecked)
//
//                        }
//            }

}