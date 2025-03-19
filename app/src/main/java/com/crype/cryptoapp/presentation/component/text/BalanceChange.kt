package com.crype.cryptoapp.presentation.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.crype.cryptoapp.presentation.ui.theme.Green
import com.crype.cryptoapp.presentation.ui.theme.Red
import com.crype.cryptoapp.presentation.ui.theme.SFPro
import com.crype.cryptoapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun BalanceChange(
    isPlus: Boolean,
    value: Float,
    procent: Float,
    fontSize: TextUnit,
    viewModel: MainViewModel
) {
    Text(
        text = if (isPlus)
            "+${viewModel.formatFloat(value, 2)} $ (+${viewModel.formatFloat(procent, 2)} %)"
        else "${viewModel.formatFloat(value, 2)} $ (${viewModel.formatFloat(procent, 2)} %)",
        color = if (isPlus) Green else Red,
        fontSize = fontSize,
        fontFamily = SFPro,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.sp
    )
}