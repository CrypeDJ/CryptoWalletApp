package com.crype.cryptoapp.presentation.di

import com.crype.cryptoapp.presentation.viewmodel.MainViewModel
import org.koin.dsl.module

val appModule = module {
    single { MainViewModel() }
}