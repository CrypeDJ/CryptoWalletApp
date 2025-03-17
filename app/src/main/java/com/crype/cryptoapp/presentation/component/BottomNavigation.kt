package com.crype.cryptoapp.presentation.component

import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.crype.cryptoapp.presentation.navigation.Screens
import com.crype.cryptoapp.presentation.ui.theme.White

@Composable
fun BottomNavigation(
    navController: NavController
) {
    val screens = listOf(
        Screens.HomeScreen,
        Screens.SettingScreen
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomAppBar(
        actions = {
            screens.forEach {
                NavigationBarItem(
                    screen = it,
                    navDestination = currentDestination,
                    navController = navController
                )
            }
        },
        containerColor = White,
    )
}