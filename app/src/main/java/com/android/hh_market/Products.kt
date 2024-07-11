package com.android.hh_market

object Products {

    private var prodictList = initProductData()
    private fun initProductData(): MutableList<ProductInfo> {

        return mutableListOf(
            ProductInfo()
        )
    }
}