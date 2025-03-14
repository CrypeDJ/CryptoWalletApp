package com.crype.cryptoapp.presentation.navigation

sealed class Screens(val route: String) {
    object HomeScreen : Screens(route = "home_screen")
    object CoinDetailScreen : Screens(route = "coin_detail_screen")
    object CoinSelectScreen : Screens(route = "coin_select_screen")
    object AddTransactionScreen : Screens(route = "add_transaction_screen")
    object SettingScreen : Screens(route = "setting_screen")
}