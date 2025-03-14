package com.crype.cryptoapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.crype.cryptoapp.R
import com.crype.cryptoapp.presentation.component.text.CenterText

@Composable
fun EmptyBalanceComponent(
    text: String,
    color: Color,
    fontFamily: FontFamily,
    fontWeight: FontWeight,
    fontSize: TextUnit,
    imageHeight: Dp,
    spaceBetween: Dp,
    onClick: () -> Unit
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(spaceBetween)
    ) {
        Image(
            painter = painterResource(id = R.drawable.banana),
            contentDescription = "banana",
            modifier = Modifier
                .height(imageHeight)
        )
        CenterText(
            text = text,
            color = color,
            fontFamily = fontFamily,
            fontWeight = fontWeight,
            fontSize = fontSize,
            bottomPadding = 0.dp
        )
        AddTransactionButton(
            onClick = onClick,
            iconSize = 20.dp,
            spaceBetween = 8.dp,
            verticalPadding = 15.dp,
            horizontalPadding = 15.dp
        )
    }
}