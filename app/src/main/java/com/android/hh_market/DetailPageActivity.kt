package com.android.hh_market

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        cbList.forEach {
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
}