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
import com.crype.cryptoapp.core.common.CoinInfo
import com.crype.cryptoapp.domain.model.CryptoValuesModel
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
fun StartScreen(
    navController: NavController,
    viewModel: MainViewModel = koinViewModel()
) {
    val walletBalance = CryptoValuesModel(
        valueInCrypto = 0f,
        valueInUSD = 0f,
        coinInfo = CoinInfo.BTC,
        changesUSD = -1230f
    )
    val coinList = listOf(
        CryptoValuesModel(
            valueInCrypto = 4.4f,
            valueInUSD = 2345.4f,
            coinInfo = CoinInfo.BTC,
            changesUSD = 0f
        ),
        CryptoValuesModel(
            valueInCrypto = 4.4f,
            valueInUSD = 2345.4f,
            coinInfo = CoinInfo.ADA,
            changesUSD = 1230f
        ),
        CryptoValuesModel(
            valueInCrypto = 4.4f,
            valueInUSD = 2345.4f,
            coinInfo = CoinInfo.TON,
            changesUSD = -1230f
        )
    )
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
                walletBalance.valueInUSD,
                0
            ) + " " + stringResource(id = R.string.usd),
            color = Black,
            fontFamily = SFPro,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            bottomPadding = 5.dp
        )
        if (walletBalance.valueInCrypto == 0f) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                EmptyBalanceComponent(
                    text = stringResource(id = R.string.null_transaction),
                    color = Gray,
                    fontFamily = SFPro,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    imageHeight = 128.dp,
                    spaceBetween = 13.dp
                ) {
                    navController.navigate(route = Screens.CoinSelectScreen.route)
                }
            }
        } else {
            NotEmptyBalanceComponent(
                coinList = coinList,
                balanceChangeTopPadding = 0.dp,
                balanceChangeBottomPadding = 30.dp,
                isPlus = walletBalance.changesUSD > 0,
                value = walletBalance.changesUSD,
                procent = walletBalance.valueInUSD,
                balanceChangeFontSize = 14.sp,
                spaceBetweenBalanceChange = 5.dp,
                onCoinDetailClick = {
                    viewModel.selectCoin(it.coinInfo)
                    navController.navigate(route = Screens.CoinDetailScreen.route)
                }
            ) {
                navController.navigate(route = Screens.CoinSelectScreen.route)
            }
        }
    }
}