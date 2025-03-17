package com.crype.cryptoapp.presentation.navigation

import com.crype.cryptoapp.R

sealed class Screens(
    val route: String,
    val icon: Int?,
    val title: Int?
) {
    object HomeScreen : Screens(
        route = "home_screen",
        icon = R.drawable.home,
        title = R.string.home
    )
    object CoinDetailScreen : Screens(
        route = "coin_detail_screen",
        icon = null,
        title = null
    )
    object CoinSelectScreen : Screens(
        route = "coin_select_screen",
        icon = null,
        title = R.string.add_transaction
    )
    object AddTransactionScreen : Screens(
        route = "add_transaction_screen",
        icon = null,
        title = R.string.add_transaction
    )
    object SettingScreen : Screens(
        route = "setting_screen",
        icon = R.drawable.settings,
        title = R.string.settings
    )
}