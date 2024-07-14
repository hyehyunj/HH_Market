package com.android.hh_market

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.android.hh_market.databinding.ActivityDetailPageBinding
import com.android.hh_market.databinding.ActivityMainPageBinding
import com.android.hh_market.databinding.ItemRecyclerviewBinding

class DetailPageActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "DetailPageActivity" }

    private lateinit var _binding : ActivityDetailPageBinding
    private val productList = Product.getProductData()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        val position = intent.getIntExtra("data",0)

with(_binding) {
    ivDetailTitle.setImageResource(productList[position].image)
    tvDetailSeller.setText(productList[position].seller)
    tvDetailLocation.setText(productList[position].location)
    tvDetailTitle.setText(productList[position].title)
    tvDetailIntroduce.setText(productList[position].introduce)

}



    }

//    fun setData(position :Int){
//        setImageResource(productList[position].image)
//
//    }
//    inner class Holder()  {
//    val image = _binding.ivDetailTitle
//    val title = _binding.ivDetailSeller
//    val location = _binding.ivDetailSeller
//    }

//
//        fun cbLikeListener() {
//            _binding.btnDetailChat
//        cbLike.forEach {
//            it.setOnCheckedChangeListener { _, ischecked ->
//                if (it.isChecked) {
//                    tagsData += it.text.toString()
//                    if (tagsData.size == 3) {
//                        Toast.makeText(
//                            this,
//                            getString(R.string.toast_signup_favorite_max3),
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        for (i in cbList) if (!i.isChecked) i.isEnabled = false
//                    }
//                } else {
//                    tagsData -= it.text.toString()
//                    for (i in cbList) if (!i.isChecked) i.isEnabled = true
//                }
//            }
//
//    }
}