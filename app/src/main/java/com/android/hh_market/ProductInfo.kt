package com.android.hh_market

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductInfo(
    val image: Int,
    val title: Int,
    val introduce: Int,
    val seller: Int,
    val price: Int,
    val location: Int,
    val level: Int,
    val chat : Int,
    var like : Int
) : Parcelable