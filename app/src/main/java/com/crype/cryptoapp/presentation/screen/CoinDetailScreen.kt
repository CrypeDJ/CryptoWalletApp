package com.crype.cryptoapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.cryptoapp.R
import com.crype.cryptoapp.domain.model.CryptoValuesModel
import com.crype.cryptoapp.domain.model.TransactionModel
import com.crype.cryptoapp.presentation.component.PriceCard
import com.crype.cryptoapp.presentation.component.TransactionListItem
import com.crype.cryptoapp.presentation.component.text.BalanceChange
import com.crype.cryptoapp.presentation.component.text.CenterText
import com.crype.cryptoapp.presentation.ui.theme.Black
import com.crype.cryptoapp.presentation.ui.theme.Gray
import com.crype.cryptoapp.presentation.ui.theme.SFCompact
import com.crype.cryptoapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CoinDetailScreen(
    viewModel: MainViewModel = koinViewModel()
) {
    val coinBalance = CryptoValuesModel(
        valueInCrypto = 0f,
        valueInUSD = 24715.63f,
        coinInfo = viewModel.selectedCoin.value,
        changesUSD = 341.1f
    )
    val averagePrice = 79129.13f
    val currentPrice = 97673.84f
    val transactionList = listOf(
        TransactionModel(
            date = 1000000000000,
            value = 30.4f
        ),
        TransactionModel(
            date = 1500000000000,
            value = -30.4f
        ),
        TransactionModel(
            date = 1099900000000,
            value = 30.4f
        )
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 15.dp)
    ) {
        Image(
            painter = painterResource(id = coinBalance.coinInfo.coinImage),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        CenterText(
            text = "${viewModel.formatFloat(coinBalance.valueInUSD, 2)} $",
            color = Black,
            fontFamily = SFCompact,
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            bottomPadding = 7.dp
        )
        BalanceChange(
            isPlus = coinBalance.changesUSD > 0,
            value = coinBalance.changesUSD,
            procent = coinBalance.changesUSD,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PriceCard(
                modifier = Modifier.weight(1f),
                price = averagePrice,
                text = R.string.average_price,
                spaceBetween = 3.dp,
                textSize = 12.sp,
                priceSize = 20.sp
            )
            PriceCard(
                modifier = Modifier.weight(1f),
                price = currentPrice,
                text = R.string.current_price,
                spaceBetween = 3.dp,
                textSize = 12.sp,
                priceSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
        ) {
            Text(
                text = stringResource(id = R.string.transaction),
                fontSize = 16.sp,
                fontFamily = SFCompact,
                fontWeight = FontWeight.Medium,
                color = Gray,
                textAlign = TextAlign.Start,
                letterSpacing = 0.sp
            )
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(transactionList) {
                TransactionListItem(
                    transaction = it,
                    imageSize = 40.dp,
                    titleSize = 18.sp,
                    descSize = 14.sp
                )
            }
        }
    }
}