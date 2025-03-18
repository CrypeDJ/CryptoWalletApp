package com.crype.cryptoapp.presentation.component.text

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun CenterText(
    text: String,
    color: Color,
    fontFamily: FontFamily,
    fontWeight: FontWeight,
    fontSize: TextUnit,
    bottomPadding: Dp
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = bottomPadding),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = color,
            fontFamily = fontFamily,
            fontWeight = fontWeight,
            fontSize = fontSize,
            letterSpacing = 0.sp
        )
    }
}