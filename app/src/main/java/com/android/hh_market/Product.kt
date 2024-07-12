package com.android.hh_market

object Product {
    fun getProductData() = initProductData()

    //데이터 보호
    private fun initProductData(): MutableList<ProductInfo> {

        return mutableListOf(

            ProductInfo(
                R.drawable.img_fan,
                R.string.fan_title,
                R.string.fan_introduce,
                R.string.fan_seller,
                R.string.fan_price,
                R.string.fan_location
            ),
            ProductInfo(
                R.drawable.img_kimchi_fridge,
                R.string.kimchi_fridge_title,
                R.string.kimchi_fridge_introduce,
                R.string.kimchi_fridge_seller,
                R.string.kimchi_fridge_price,
                R.string.kimchi_fridge_location
            ),
            ProductInfo(
                R.drawable.img_chanel_wallet,
                R.string.chanel_wallet_title,
                R.string.chanel_wallet_introduce,
                R.string.chanel_wallet_seller,
                R.string.chanel_wallet_price,
                R.string.chanel_wallet_location
            ),
            ProductInfo(
                R.drawable.img_safe,
                R.string.safe_title,
                R.string.safe_introduce,
                R.string.safe_seller,
                R.string.safe_price,
                R.string.safe_location
            ),
            ProductInfo(
                R.drawable.img_smart_phone,
                R.string.smart_phone_title,
                R.string.smart_phone_introduce,
                R.string.smart_phone_seller,
                R.string.smart_phone_price,
                R.string.smart_phone_location
            ),
            ProductInfo(
                R.drawable.img_prada_bag,
                R.string.prada_bag_title,
                R.string.prada_bag_introduce,
                R.string.prada_bag_seller,
                R.string.prada_bag_price,
                R.string.prada_bag_location
            ),
            ProductInfo(
                R.drawable.img_tiket,
                R.string.tiket_title,
                R.string.tiket_introduce,
                R.string.tiket_seller,
                R.string.tiket_price,
                R.string.tiket_location
            ),
            ProductInfo(
                R.drawable.img_chanel_bag,
                R.string.chanel_bag_title,
                R.string.chanel_bag_introduce,
                R.string.chanel_bag_seller,
                R.string.chanel_bag_price,
                R.string.chanel_bag_location
            ),
            ProductInfo(
                R.drawable.img_spray,
                R.string.spray_title,
                R.string.spray_introduce,
                R.string.spray_seller,
                R.string.spray_price,
                R.string.spray_location
            ),
            ProductInfo(
                R.drawable.img_celine_bag,
                R.string.celine_bag_title,
                R.string.celine_bag_introduce,
                R.string.celine_bag_seller,
                R.string.celine_bag_price,
                R.string.celine_bag_location
            )


        )
    }
}