package com.crype.cryptoapp.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crype.cryptoapp.core.common.CoinInfo
import com.crype.cryptoapp.domain.model.CryptoValuesModel
import com.crype.cryptoapp.domain.model.TransactionModel
import com.crype.cryptoapp.domain.repository.TransactionsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainViewModel(
    private val transactionsRepository: TransactionsRepository
) : ViewModel() {

    private val _selectedCoin = MutableStateFlow<CoinInfo?>(null)
    val selectedCoin: StateFlow<CoinInfo?> = _selectedCoin.asStateFlow()

    private val _transactions = mutableStateListOf<TransactionModel>()
    val transactions: List<TransactionModel> = _transactions

    init {
        loadTransactions()
    }

    fun selectCoin(coin: CoinInfo) {
        _selectedCoin.value = coin
        Log.d("MainViewModel", "Selected coin: ${coin.coinName}")
    }

    fun clearSelectedCoin() {
        _selectedCoin.value = null
    }

    fun formatFloat(number: Float, maxDecimalPlaces: Int): String {
        val rounded = BigDecimal(number.toString()).setScale(maxDecimalPlaces, RoundingMode.HALF_UP)
        return if (rounded.stripTrailingZeros().scale() <= 0) {
            rounded.toBigInteger().toString()
        } else {
            rounded.stripTrailingZeros().toPlainString()
        }
    }

    fun formatTimestampToDate(timestamp: Long): String {
        val date = Date(timestamp * 1000)
        val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        return formatter.format(date)
    }

    fun saveTransaction(value: Float, price: Float) {
        viewModelScope.launch {
            _selectedCoin.value?.let { coin ->
                val transaction = TransactionModel(
                    date = System.currentTimeMillis() / 1000,
                    value = value,
                    price = price,
                    coin = coin
                )
                Log.d("Time", transaction.date.toString())
                transactionsRepository.addTransaction(transaction)
                _transactions.add(transaction)
                clearSelectedCoin()
            }
        }
    }

    private fun loadTransactions() {
        viewModelScope.launch {
            _transactions.clear()
            _transactions.addAll(transactionsRepository.getTransactions())
        }
    }

    private fun calculateTotalUSD(transactions: List<TransactionModel>): Float {
        var total = 0f
        transactions.forEach {
            total += it.value * it.coin.currentPrice
        }
        return total
    }

    private fun calculateTotalBeforeUSD(transactions: List<TransactionModel>): Float {
        var totalBefore = 0f
        transactions.forEach {
            totalBefore += it.value * it.coin.yesterdayPrice
        }
        return totalBefore
    }

    fun calculateTotal(): Float {
        return calculateTotalUSD(_transactions)
    }

    fun calculateTotalChanges(): Float {
        return calculateTotalUSD(_transactions) - calculateTotalBeforeUSD(_transactions)
    }

    fun calculateTotalChangesProcent(): Float {
        return calculateTotalChanges() / calculateTotalBeforeUSD(_transactions) * 100
    }

    fun calculateTotalCoin(): Float {
        return calculateTotalUSD(_transactions.filter { it.coin == _selectedCoin.value })
    }

    fun calculateTotalChangesCoin(): Float {
        return calculateTotalUSD(_transactions.filter { it.coin == _selectedCoin.value }) - calculateTotalBeforeUSD(
            _transactions.filter { it.coin == _selectedCoin.value })
    }

    fun calculateTotalChangesProcentCoin(): Float {
        return calculateTotalChangesCoin() / calculateTotalBeforeUSD(_transactions.filter { it.coin == _selectedCoin.value }) * 100
    }

    fun calculateAveragePurchasePrice(): Float {
        var totalPurchase = 0f
        var totalTokens = 0f
        _transactions.filter { it.coin == _selectedCoin.value }.forEach {
            totalPurchase += it.value * it.price
            totalTokens += it.value
        }
        return totalPurchase / totalTokens
    }

    fun aggregateTransactions(): List<CryptoValuesModel> {
        return _transactions
            .groupBy { it.coin }
            .map { (coin, group) ->
                CryptoValuesModel(
                    coinInfo = coin,
                    valueInCrypto = group.sumOf { it.value.toDouble() }.toFloat(),
                    valueInUSD = group.sumOf { it.value.toDouble() }.toFloat() * coin.currentPrice,
                    changesUSD = group.sumOf { it.value.toDouble() }
                        .toFloat() * (coin.currentPrice - coin.yesterdayPrice)
                )
            }
    }

    fun isValidDecimalInput(input: String, maxLength: Int): Boolean {
        if (maxLength < 0) return false
        val pattern = "^\\d*\\.?\\d{0,$maxLength}$".toRegex()
        return input.matches(pattern) && input.count { it == '.' } <= 1
    }
}