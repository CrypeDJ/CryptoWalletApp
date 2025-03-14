package com.crype.cryptoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crype.cryptoapp.presentation.component.BottomNavigation
import com.crype.cryptoapp.presentation.component.TopBar
import com.crype.cryptoapp.presentation.screen.StartScreen
import com.crype.cryptoapp.presentation.ui.theme.CryptoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoAppTheme {
                Scaffold(
                    containerColor = Color.White,
                    topBar = {
                        TopBar(
                            title = ""
                        )
                    },
                    bottomBar = {
                        BottomNavigation()
                    }
                ) {innerPadding ->
                    Box (
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(horizontal = 15.dp)
                    ){
                        StartScreen()
                    }
                }
            }
        }
    }
}
