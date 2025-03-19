package com.crype.cryptoapp.core.common

import com.crype.cryptoapp.R

enum class CoinInfo(
    val coinName: String,
    val coinLetters: String,
    val coinImage: Int,
    val currentPrice: Float,
    val yesterdayPrice: Float
) {
    BTC("Bitcoin", "BTC", R.drawable.bitcoin, 83772.01f, 82561.57f),
    ADA("ADA", "ADA", R.drawable.ada, 0.7217f, 0.702f),
    TON("Toncoin", "TON", R.drawable.toncoin,3.59f, 3.5659f),
    BLUM("Blum", "BLUM", R.drawable.blum, 0f,0f)
}