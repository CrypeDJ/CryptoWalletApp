package com.crype.cryptoapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.crype.cryptoapp.presentation.screen.AddTransactionScreen
import com.crype.cryptoapp.presentation.screen.CoinDetailScreen
import com.crype.cryptoapp.presentation.screen.CoinSelectScreen
import com.crype.cryptoapp.presentation.screen.SettingScreen
import com.crype.cryptoapp.presentation.screen.StartScreen
import com.crype.cryptoapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String,
    viewModel: MainViewModel
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screens.HomeScreen.route) {
            StartScreen(navController,viewModel)
        }
        composable(route = Screens.CoinDetailScreen.route) {
            CoinDetailScreen(viewModel)
        }
        composable(route = Screens.CoinSelectScreen.route) {
            CoinSelectScreen(navController, viewModel)
        }
        composable(route = Screens.AddTransactionScreen.route) {
            AddTransactionScreen(navController, viewModel)
        }
        composable(route = Screens.SettingScreen.route) {
            SettingScreen()
        }
    }
}