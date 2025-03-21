package com.crype.cryptoapp.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.cryptoapp.presentation.ui.theme.SFPro

@Composable
fun MainButton(
    containerColor: Color,
    disabledContainerColor: Color,
    textColor: Color,
    enabled: Boolean,
    modifier: Modifier,
    text: String,
    verticalPadding: Dp,
    horizontalPadding: Dp,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = containerColor,
            disabledContainerColor = disabledContainerColor,
        ),
        enabled = enabled,
        modifier = modifier
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = SFPro,
            letterSpacing = 0.sp,
            modifier = Modifier
                .padding(vertical = verticalPadding, horizontal = horizontalPadding),
            color = textColor
        )
    }
}