package com.crype.cryptoapp.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crype.cryptoapp.presentation.navigation.Screens
import com.crype.cryptoapp.presentation.ui.theme.BackgroundBlock
import com.crype.cryptoapp.presentation.ui.theme.Black
import com.crype.cryptoapp.presentation.ui.theme.SFCompact
import com.crype.cryptoapp.presentation.ui.theme.White

@Composable
fun BottomNavigation(
    navController: NavController,
    currentRoute: String?
) {
    val screens = listOf(
        Screens.HomeScreen,
        Screens.SettingScreen
    )
    if (currentRoute != null && screens.any { it.route == currentRoute }) {
        Box(
            modifier = Modifier
                .padding(bottom = 40.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors().copy(
                    containerColor = BackgroundBlock
                ),
                modifier = Modifier.height(40.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 4.dp)
                ) {
                    screens.forEach {
                        Card(
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors().copy(
                                containerColor = if (currentRoute == it.route) White else Color.Transparent
                            ),
                            onClick = {
                                navController.navigate(it.route)
                            },
                            modifier = Modifier
                                .size(width = 131.dp, height = 32.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(5.dp),
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .fillMaxHeight()
                            ) {
                                if (currentRoute == it.route) {
                                    Icon(
                                        painter = painterResource(id = it.icon ?: 0),
                                        contentDescription = null,
                                        tint = Black,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                                Text(
                                    text = stringResource(id = it.title ?: 0),
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = SFCompact,
                                    letterSpacing = 0.sp,
                                    color = Black
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}