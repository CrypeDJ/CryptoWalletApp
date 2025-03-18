package com.crype.cryptoapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.crype.cryptoapp.core.common.CoinInfo
import kotlin.math.pow
import kotlin.math.roundToInt

class MainViewModel : ViewModel() {

    private val _selectedCoin = mutableStateOf(CoinInfo.BTC)
    val selectedCoin: State<CoinInfo> = _selectedCoin

    fun selectCoin(coin: CoinInfo) {
        _selectedCoin.value = coin
    }

    fun formatFloat(number: Float, maxDecimalPlaces: Int): String {
        val multiplier = 10.0.pow(maxDecimalPlaces).toFloat()
        val rounded = (number * multiplier).roundToInt() / multiplier
        return if (rounded == rounded.toInt().toFloat()) rounded.toInt()
            .toString() else "%.\${maxDecimalPlaces}f".format(rounded)
    }
}