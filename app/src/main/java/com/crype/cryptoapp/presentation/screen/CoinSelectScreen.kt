package com.crype.cryptoapp.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crype.cryptoapp.R
import com.crype.cryptoapp.core.common.CoinInfo
import com.crype.cryptoapp.presentation.component.MainButton
import com.crype.cryptoapp.presentation.component.SelectCoinItem
import com.crype.cryptoapp.presentation.navigation.Screens
import com.crype.cryptoapp.presentation.ui.theme.BackgroundBlock
import com.crype.cryptoapp.presentation.ui.theme.Blue
import com.crype.cryptoapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CoinSelectScreen(
    navController: NavController,
    viewModel: MainViewModel = koinViewModel()
) {
    val coins = listOf(CoinInfo.BTC, CoinInfo.ADA, CoinInfo.TON, CoinInfo.BLUM)
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(top = 20.dp)
        ) {
            items(coins){
                SelectCoinItem(
                    iconSize = 32.dp,
                    fontSize = 18.sp,
                    verticalPadding = 10.dp,
                    horizontalPadding = 10.dp,
                    spaceBetween = 8.dp,
                    coin = it,
                ){
                    viewModel.selectCoin(it)
                    navController.navigate(route = Screens.AddTransactionScreen.route)
                }
            }
        }
        MainButton(
            containerColor = BackgroundBlock,
            disabledContainerColor = BackgroundBlock,
            textColor = Blue,
            enabled = true,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 30.dp)
                .fillMaxWidth(),
            text = stringResource(id = R.string.cansel),
            verticalPadding = 10.dp,
            horizontalPadding = 0.dp
        ) {
            navController.navigate(route = Screens.HomeScreen.route)
        }
    }
}
