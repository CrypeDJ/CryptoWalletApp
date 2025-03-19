package com.crype.cryptoapp.domain.model

import com.crype.cryptoapp.core.common.CoinInfo

data class TransactionModel(
    val date: Long,
    val value: Float,
    val coin: CoinInfo,
    val price: Float
)
