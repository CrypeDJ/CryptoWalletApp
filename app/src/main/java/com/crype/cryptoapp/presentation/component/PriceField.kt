package com.crype.cryptoapp.presentation.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.cryptoapp.R
import com.crype.cryptoapp.presentation.ui.theme.BackgroundBlock
import com.crype.cryptoapp.presentation.ui.theme.Black
import com.crype.cryptoapp.presentation.ui.theme.Gray
import com.crype.cryptoapp.presentation.ui.theme.SFPro

@Composable
fun PriceField(
    value: String,
    modifier: Modifier,
    onValueChange: (String) -> Unit,

){
    TextField(
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors().copy(
            focusedContainerColor = BackgroundBlock,
            unfocusedContainerColor = BackgroundBlock,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = modifier,
        placeholder = {
            Text(
                text = stringResource(id = R.string.price),
                fontFamily = SFPro,
                fontSize = 17.sp,
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.sp,
                color = Gray
            )
        },
        textStyle = TextStyle(
            fontFamily = SFPro,
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.sp,
            color = Black
        )
    )
}