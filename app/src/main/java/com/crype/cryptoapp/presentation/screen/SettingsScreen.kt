package com.crype.cryptoapp.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.cryptoapp.R
import com.crype.cryptoapp.presentation.component.SettingsItem

@Composable
fun SettingScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SettingsItem(
            horizontalPadding = 15.dp,
            mainText = stringResource(id = R.string.currency),
            descText = stringResource(id = R.string.usd),
            fontSize = 18.sp,
            verticalPadding = 15.dp
        ){}
        SettingsItem(
            horizontalPadding = 15.dp,
            mainText = stringResource(id = R.string.theme),
            descText = stringResource(id = R.string.light),
            fontSize = 18.sp,
            verticalPadding = 15.dp
        ){}
    }
}
