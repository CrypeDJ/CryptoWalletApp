package com.crype.cryptoapp.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    Box(
        modifier = Modifier.padding(bottom = 20.dp)
    ){

    }

}