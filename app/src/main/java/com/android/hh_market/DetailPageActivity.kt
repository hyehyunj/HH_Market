package com.android.hh_market

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.hh_market.databinding.ActivityDetailPageBinding
import com.android.hh_market.databinding.ActivityMainPageBinding

class DetailPageActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityDetailPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(_binding.root)
    }

        fun cbLikeListener() {
            _binding.btnDetailChat
        cbLike.forEach {
            it.setOnCheckedChangeListener { _, ischecked ->
                if (it.isChecked) {
                    tagsData += it.text.toString()
                    if (tagsData.size == 3) {
                        Toast.makeText(
                            this,
                            getString(R.string.toast_signup_favorite_max3),
                            Toast.LENGTH_SHORT
                        ).show()
                        for (i in cbList) if (!i.isChecked) i.isEnabled = false
                    }
                } else {
                    tagsData -= it.text.toString()
                    for (i in cbList) if (!i.isChecked) i.isEnabled = true
                }
            }

    }
}