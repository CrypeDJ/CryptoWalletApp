package com.crype.cryptoapp.presentation.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.crype.cryptoapp.presentation.navigation.Screens
import com.crype.cryptoapp.presentation.ui.theme.Black
import com.crype.cryptoapp.presentation.ui.theme.SFCompact

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
                contentDescription = " NavBar Icon",
                tint = Black
            )
        },
        label = {
            Text(
                text = stringResource(id = screen.title ?: 0),
                letterSpacing = 0.sp,
                color = Black,
                fontFamily = SFCompact,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        },
        selected = navDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
            navController.navigate(screen.route)
        }
    )
}