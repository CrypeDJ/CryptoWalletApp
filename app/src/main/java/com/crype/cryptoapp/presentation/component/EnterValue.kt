package com.crype.cryptoapp.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.crype.cryptoapp.presentation.ui.theme.Black
import com.crype.cryptoapp.presentation.ui.theme.Blue
import com.crype.cryptoapp.presentation.ui.theme.Gray
import com.crype.cryptoapp.presentation.ui.theme.SFPro

@Composable
fun EnterValue(
    fontSize: TextUnit,
    value: String,
    modifier: Modifier,
    onValueChange: (String) -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            colors = TextFieldDefaults.colors().copy(
                focusedTextColor = Black,
                unfocusedTextColor = Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                cursorColor = Blue
            ),
            textStyle = TextStyle(
                fontFamily = SFPro,
                fontSize = fontSize,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Center
            ),
            placeholder = {
                Text(
                    text = "0",
                    color = Gray,
                    fontFamily = SFPro,
                    fontSize = fontSize,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
    }
}