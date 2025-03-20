package com.crype.cryptoapp.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crype.cryptoapp.R
import com.crype.cryptoapp.presentation.component.EmptyBalanceComponent
import com.crype.cryptoapp.presentation.component.NotEmptyBalanceComponent
import com.crype.cryptoapp.presentation.component.text.CenterText
import com.crype.cryptoapp.presentation.navigation.Screens
import com.crype.cryptoapp.presentation.ui.theme.Black
import com.crype.cryptoapp.presentation.ui.theme.Gray
import com.crype.cryptoapp.presentation.ui.theme.SFPro
import com.crype.cryptoapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun StartScreen(navController: NavController, viewModel: MainViewModel) {
    Column {
        CenterText(
            text = stringResource(id = R.string.total),
            color = Gray,
            fontFamily = SFPro,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            bottomPadding = 5.dp
        )

        CenterText(
            text = viewModel.formatFloat(
                viewModel.calculateTotal(),
                0
            ) + " " + stringResource(id = R.string.usd),
            color = Black,
            fontFamily = SFPro,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            bottomPadding = 5.dp
        )

        if (viewModel.calculateTotal() == 0f) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                EmptyBalanceComponent(
                    text = stringResource(id = R.string.null_transaction),
                    color = Gray,
                    fontFamily = SFPro,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    imageHeight = 128.dp,
                    spaceBetween = 13.dp
                ) {
                    navController.navigate(Screens.CoinSelectScreen.route)
                }
            }
        } else {
            NotEmptyBalanceComponent(
                coinList = viewModel.aggregateTransactions(),
                balanceChangeTopPadding = 0.dp,
                balanceChangeBottomPadding = 30.dp,
                isPlus = viewModel.calculateTotalChanges() > 0,
                value = viewModel.calculateTotalChanges(),
                procent = viewModel.calculateTotalChangesProcent(),
                balanceChangeFontSize = 14.sp,
                spaceBetweenBalanceChange = 5.dp,
                viewModel = viewModel,
                onCoinDetailClick = {
                    viewModel.selectCoin(it.coinInfo)
                    navController.navigate(Screens.CoinDetailScreen.route)
                }
            ) {
                navController.navigate(Screens.CoinSelectScreen.route)
            }
        }
    }
}
