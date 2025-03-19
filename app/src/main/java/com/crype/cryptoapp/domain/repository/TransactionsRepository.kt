package com.crype.cryptoapp.domain.repository

import com.crype.cryptoapp.domain.model.TransactionModel

interface TransactionsRepository {
    suspend fun addTransaction(transaction: TransactionModel)
    suspend fun getTransactions(): List<TransactionModel>
}