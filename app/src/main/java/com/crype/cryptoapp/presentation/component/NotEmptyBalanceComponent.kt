package com.crype.cryptoapp.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.cryptoapp.R
import com.crype.cryptoapp.domain.model.CryptoValuesModel
import com.crype.cryptoapp.presentation.component.text.BalanceChange
import com.crype.cryptoapp.presentation.ui.theme.Gray
import com.crype.cryptoapp.presentation.ui.theme.SFPro

@Composable
fun NotEmptyBalanceComponent(
    onClick: () -> Unit,
    coinList: List<CryptoValuesModel>,
    balanceChangeTopPadding: Dp,
    balanceChangeBottomPadding: Dp,
    isPlus: Boolean,
    value: Float,
    procent: Float,
    balanceChangeFontSize: TextUnit,
    spaceBetweenBalanceChange: Dp,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(spaceBetweenBalanceChange),
            modifier = Modifier
                .padding(top = balanceChangeTopPadding, bottom = balanceChangeBottomPadding)
        ) {
            BalanceChange(
                isPlus = isPlus,
                value = value,
                procent = procent,
                fontSize = balanceChangeFontSize
            )
            Text(
                text = stringResource(id = R.string.all_time),
                fontFamily = SFPro,
                fontSize = balanceChangeFontSize,
                fontWeight = FontWeight.SemiBold,
                color = Gray,
                letterSpacing = 0.sp
            )
        }
        AddTransactionButton(
            onClick = onClick,
            iconSize = 20.dp,
            spaceBetween = 8.dp,
            verticalPadding = 15.dp,
            horizontalPadding = 15.dp
        )
        Spacer(modifier = Modifier.padding(20.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(coinList){
                CoinListItem(
                    cryptoValuesModel = it,
                    imageSize = 40.dp,
                    titleSize = 18.sp,
                    descSize = 14.sp,
                    onClick = { /*TODO*/ },
                )
            } 
        }
    }
}