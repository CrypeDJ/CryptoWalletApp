package com.crype.cryptoapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.crype.cryptoapp.presentation.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    //navController: NavController
){
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = White
        ),
        title = {
            if (title != null) {

            }
        }
    )
}