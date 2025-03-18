package com.crype.cryptoapp.core.common

import com.crype.cryptoapp.R

enum class CoinInfo(
    val coinName: String,
    val coinLetters: String,
    val coinImage: Int
) {
    BTC("Bitcoin", "BTC", R.drawable.bitcoin),
    ADA("ADA", "ADA", R.drawable.ada),
    TON("Toncoin", "TON", R.drawable.toncoin),
    BLUM("Blum", "BLUM", R.drawable.blum)


}