package com.crype.cryptoapp.presentation.di

import com.crype.cryptoapp.data.repository.TransactionRepositoryImpl
import com.crype.cryptoapp.domain.repository.TransactionsRepository
import com.crype.cryptoapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get()) }

    single<TransactionsRepository> { TransactionRepositoryImpl() }
}