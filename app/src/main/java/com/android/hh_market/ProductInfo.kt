package com.android.hh_market

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductInfo(
    val image: Int,
    val title: String,
    val introduce: String,
    val seller: String,
    val price: Int,
    val location: String,
    val level: Int,
    val chat : Int,
    var like : Int
) : Parcelable