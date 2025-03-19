package com.crype.cryptoapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import com.crype.cryptoapp.domain.model.TransactionModel
import com.crype.cryptoapp.presentation.ui.theme.BackgroundBlock
import com.crype.cryptoapp.presentation.ui.theme.BackgroundGreen
import com.crype.cryptoapp.presentation.ui.theme.Black
import com.crype.cryptoapp.presentation.ui.theme.Gray
import com.crype.cryptoapp.presentation.ui.theme.Green
import com.crype.cryptoapp.presentation.ui.theme.Red
import com.crype.cryptoapp.presentation.ui.theme.SFCompact
import com.crype.cryptoapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TransactionListItem(
    transaction: TransactionModel,
    imageSize: Dp,
    titleSize: TextUnit,
    descSize: TextUnit,
    viewModel: MainViewModel
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = BackgroundBlock
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 13.dp, vertical = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(imageSize)
                    .background(
                        color = BackgroundGreen,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Green,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                )
            }
            Spacer(modifier = Modifier.padding(7.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = stringResource(
                            id = if (transaction.value > 0) R.string.replenishment
                            else R.string.withdrawal
                        ),
                        color = Black,
                        fontFamily = SFCompact,
                        fontWeight = FontWeight.Medium,
                        fontSize = titleSize,
                        letterSpacing = 0.sp
                    )
                    Text(
                        text = viewModel.formatTimestampToDate(transaction.date),
                        color = Gray,
                        fontFamily = SFCompact,
                        fontWeight = FontWeight.Medium,
                        fontSize = descSize,
                        letterSpacing = 0.sp
                    )
                }
                Text(
                    text = "${if (transaction.value > 0) "+" else ""}${
                        viewModel.formatFloat(
                            transaction.value * transaction.coin.currentPrice,
                            2
                        )
                    } $",
                    color = if (transaction.value > 0) Green else Red,
                    fontFamily = SFCompact,
                    fontWeight = FontWeight.Medium,
                    fontSize = titleSize,
                    letterSpacing = 0.sp
                )
            }
        }
    }
}