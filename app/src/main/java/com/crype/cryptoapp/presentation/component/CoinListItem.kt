package com.crype.cryptoapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.cryptoapp.domain.model.CryptoValuesModel
import com.crype.cryptoapp.presentation.ui.theme.BackgroundBlock
import com.crype.cryptoapp.presentation.ui.theme.Black
import com.crype.cryptoapp.presentation.ui.theme.Gray
import com.crype.cryptoapp.presentation.ui.theme.Green
import com.crype.cryptoapp.presentation.ui.theme.Red
import com.crype.cryptoapp.presentation.ui.theme.SFCompact
import com.crype.cryptoapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CoinListItem(
    cryptoValuesModel: CryptoValuesModel,
    imageSize: Dp,
    onClick: () -> Unit,
    titleSize: TextUnit,
    descSize: TextUnit,
    viewModel: MainViewModel
) {
    Card(
        onClick = onClick,
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
            Image(
                painter = painterResource(id = cryptoValuesModel.coinInfo.coinImage),
                contentDescription = null,
                modifier = Modifier.size(imageSize)
            )
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
                        text = cryptoValuesModel.coinInfo.coinName,
                        color = Black,
                        fontFamily = SFCompact,
                        fontWeight = FontWeight.Medium,
                        fontSize = titleSize,
                        letterSpacing = 0.sp
                    )
                    Text(
                        text = "${
                            viewModel.formatFloat(
                                cryptoValuesModel.valueInCrypto,
                                8
                            )
                        } ${cryptoValuesModel.coinInfo.coinLetters}",
                        color = Gray,
                        fontFamily = SFCompact,
                        fontWeight = FontWeight.Medium,
                        fontSize = descSize,
                        letterSpacing = 0.sp
                    )
                }
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "${viewModel.formatFloat(cryptoValuesModel.valueInUSD, 2)} $",
                        color = Black,
                        fontFamily = SFCompact,
                        fontWeight = FontWeight.Medium,
                        fontSize = titleSize,
                        letterSpacing = 0.sp
                    )
                    if (cryptoValuesModel.changesUSD != 0f) {
                        Text(
                            text = if (cryptoValuesModel.changesUSD > 0) "+${
                                viewModel.formatFloat(
                                    cryptoValuesModel.changesUSD,
                                    2
                                )
                            } $"
                            else "${viewModel.formatFloat(cryptoValuesModel.changesUSD, 2)} $",
                            color = if (cryptoValuesModel.changesUSD > 0) Green else Red,
                            fontFamily = SFCompact,
                            fontWeight = FontWeight.Medium,
                            fontSize = descSize,
                            letterSpacing = 0.sp
                        )
                    }
                }
            }
        }
    }
}
