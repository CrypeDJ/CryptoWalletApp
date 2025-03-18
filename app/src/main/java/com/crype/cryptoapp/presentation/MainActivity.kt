package com.crype.cryptoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.crype.cryptoapp.presentation.component.BottomNavigation
import com.crype.cryptoapp.presentation.component.TopBar
import com.crype.cryptoapp.presentation.navigation.NavGraph
import com.crype.cryptoapp.presentation.navigation.Screens
import com.crype.cryptoapp.presentation.ui.theme.CryptoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoAppTheme {
                val navController = rememberNavController()
                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route
                Scaffold(
                    containerColor = Color.White,
                    topBar = {
                        TopBar(
                            currentRoute = currentRoute,
                            navController = navController,
                        )
                    },
                    bottomBar = {
                        BottomNavigation(
                            navController = navController,
                            currentRoute = currentRoute
                        )
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(horizontal = 15.dp)
                    ) {
                        NavGraph(
                            navController = navController,
                            startDestination = Screens.HomeScreen.route
                        )
                    }
                }
            }
        }
    }
}
