package com.crype.cryptoapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import com.crype.cryptoapp.presentation.ui.theme.SFCompact

@Composable
fun SelectCoinItem(
    iconSize: Dp,
    fontSize: TextUnit,
    verticalPadding: Dp,
    horizontalPadding: Dp,
    spaceBetween: Dp,
    coin: CoinInfo,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = BackgroundBlock
        ),
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(spaceBetween),
            modifier = Modifier
                .padding(vertical = verticalPadding, horizontal = horizontalPadding)
        ) {
            Image(
                painter = painterResource(id = coin.coinImage),
                contentDescription = null,
                modifier = Modifier.size(iconSize)
            )
            Text(
                text = coin.coinName,
                fontSize = fontSize,
                fontFamily = SFCompact,
                fontWeight = FontWeight.Medium,
                color = Black,
                letterSpacing = 0.sp
            )
        }
    }
}