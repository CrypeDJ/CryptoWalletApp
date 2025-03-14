package com.crype.cryptoapp.presentation.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.crype.cryptoapp.presentation.navigation.Screens

@Composable
fun NavigationBarItem(
    screen: Screens,
    navDestination: NavDestination?,
    navController: NavController
) {
    NavigationDrawerItem(
        icon = {
            Icon(
                painter = painterResource(id = screen.icon ?: 0),
                contentDescription = " NavBar Icon"
            )
        },
        label = {
            Text(text = stringResource(id = screen.title ?: 0))
        },
        selected = navDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
            navController.navigate(screen.route)
        }
    )
}