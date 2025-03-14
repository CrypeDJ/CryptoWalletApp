package com.crype.cryptoapp.presentation.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.crype.cryptoapp.presentation.ui.theme.Green
import com.crype.cryptoapp.presentation.ui.theme.Red
import com.crype.cryptoapp.presentation.ui.theme.SFPro

@Composable
fun BalanceChange(
    isPlus: Boolean,
    value: Float,
    procent: Float,
    fontSize: TextUnit,
) {
    Text(
        text = if (isPlus)
            "+${value} $ (+${procent} %)"
        else "${value} $ (${procent} %)",
        color = if (isPlus) Green else Red,
        fontSize = fontSize,
        fontFamily = SFPro,
        fontWeight = FontWeight.SemiBold
    )
}