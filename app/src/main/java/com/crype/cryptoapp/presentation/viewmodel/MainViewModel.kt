package com.crype.cryptoapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.crype.cryptoapp.core.common.CoinInfo

class MainViewModel : ViewModel() {

    private val _selectedCoin = mutableStateOf(CoinInfo.BTC)
    val selectedCoin: State<CoinInfo> = _selectedCoin

    fun selectCoin(coin:CoinInfo){
        _selectedCoin.value = coin
    }
}