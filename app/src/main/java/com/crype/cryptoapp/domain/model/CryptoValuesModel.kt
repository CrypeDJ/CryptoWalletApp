package com.crype.cryptoapp.domain.model

import com.crype.cryptoapp.core.common.CoinInfo

data class CryptoValuesModel(
    val valueInCrypto: Float,
    val valueInUSD: Float,
    val changesUSD: Float,
    val coinInfo: CoinInfo
)