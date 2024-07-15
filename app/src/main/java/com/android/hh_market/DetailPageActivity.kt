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
    private var cbLikeListener = 0

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
            if (cbLikeListener == 1) {
Log.d(TAG,"d ${cbLikeListener}")
                val positionData = intent.getIntExtra("POSITION",0)
                val intent = Intent(this, MainPageActivity::class.java)
                intent.putExtra("LIKE", true)
                intent.putExtra("POSITION", positionData)
                startActivity(intent)
            } else finish()
        }
    }


        //레이아웃 함수 : 데이터 받아오기, 바인딩
        private fun setLayout() {
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
        }

        //like버튼 함수
        private fun cbLikeListener() {
            _binding.cbDetailLike.setOnCheckedChangeListener { it, ischecked ->
                if (it.isChecked) {
                    cbLikeListener++
                    Log.d(TAG,"d ${cbLikeListener}")
                    Snackbar.make(it,"관심목록에 추가되었습니다.", Snackbar.LENGTH_LONG).show()
                }else cbLikeListener--
                Log.d(TAG,"d ${cbLikeListener}")
            }
        }

    }