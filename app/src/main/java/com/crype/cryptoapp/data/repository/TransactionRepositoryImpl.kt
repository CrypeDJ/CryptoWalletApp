package com.crype.cryptoapp.data.repository

import com.crype.cryptoapp.domain.model.TransactionModel
import com.crype.cryptoapp.domain.repository.TransactionsRepository

class TransactionRepositoryImpl: TransactionsRepository {
    val transactions = mutableListOf<TransactionModel>()

    override suspend fun addTransaction(transaction: TransactionModel) {
        transactions.add(transaction)
    }

    override suspend fun getTransactions(): List<TransactionModel> {
        return transactions.toList()
    }
}