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
import com.crype.cryptoapp.core.common.CoinInfo
import com.crype.cryptoapp.presentation.ui.theme.BackgroundBlock
import com.crype.cryptoapp.presentation.ui.theme.Black
import com.crype.cryptoapp.presentation.ui.theme.Gray
import com.crype.cryptoapp.presentation.ui.theme.SFCompact

@Composable
fun BlumItem(
    imageSize: Dp,
    titleSize: TextUnit,
    descSize: TextUnit,
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
            Image(
                painter = painterResource(id = CoinInfo.BLUM.coinImage),
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
                        text = CoinInfo.BLUM.coinName,
                        color = Black,
                        fontFamily = SFCompact,
                        fontWeight = FontWeight.Medium,
                        fontSize = titleSize,
                        letterSpacing = 0.sp
                    )
                    Text(
                        text = "?",
                        color = Gray,
                        fontFamily = SFCompact,
                        fontWeight = FontWeight.Medium,
                        fontSize = descSize,
                        letterSpacing = 0.sp
                    )
                }
                Text(
                    text = "?",
                    color = Black,
                    fontFamily = SFCompact,
                    fontWeight = FontWeight.Medium,
                    fontSize = titleSize,
                    letterSpacing = 0.sp
                )
            }
        }
    }
}