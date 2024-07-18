package com.android.hh_market

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.hh_market.databinding.ActivityDetailPageBinding
import com.google.android.material.snackbar.Snackbar

class DetailPageActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityDetailPageBinding
    private lateinit var productData: ProductInfo

    companion object {
        private const val TAG = "DetailPageActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        //레이아웃 호출
        setLayout()

        //like버튼 호출
        cbLikeListener()

        //뒤로가기버튼
        _binding.btnDetailBack.setOnClickListener {
            finish()
        }
    }

    //레이아웃 함수 : 데이터 받아오기, 바인딩
    private fun setLayout() {
        productData = intent.getParcelableExtra<ProductInfo>("DATA") ?: ProductInfo(
            0,
            "",
            "",
            "",
            0,
            "",
            "",
            0,
            0,
            0,
            false
        )

        val dec = DecimalFormat("#,###원")
        with(_binding) {
            ivDetailTitle.setImageResource(productData.image)
            tvDetailSeller.text = productData.seller
            tvDetailLocation.text = productData.location
            tvDetailTitle.text = productData.title
            tvDetailIntroduce.text = productData.introduce
            tvDetailPrice.text = dec.format(productData.price)
            ivDetailLevel.setImageResource(productData.levelImage)
            tvDetailLevel.text = productData.level
        }
        when (productData.likeAdd) {
            true -> _binding.cbDetailLike.setBackgroundResource(R.drawable.ic_like_check)
            false -> _binding.cbDetailLike.setBackgroundResource(R.drawable.ic_like_default)
        }
    }

    //like버튼 함수
    private fun cbLikeListener() {
        _binding.cbDetailLike.setOnCheckedChangeListener { it, ischecked ->
            if (it.isChecked) {
                Log.d(TAG, "d 클릭전 ${productData.likeAdd}")
                productData.likeAdd = true
                productData.like++
                _binding.cbDetailLike.setBackgroundResource(R.drawable.ic_like_check)
                Log.d(TAG, "d 클릭후 ${productData.likeAdd}")
                Snackbar.make(it, "관심목록에 추가되었습니다.", Snackbar.LENGTH_SHORT).show()
            } else {
                productData.likeAdd = false
                productData.like--
                _binding.cbDetailLike.setBackgroundResource(R.drawable.ic_like_default)
                Log.d(TAG, "d 클릭제거 ${productData.likeAdd}")
            }
        }
    }
}