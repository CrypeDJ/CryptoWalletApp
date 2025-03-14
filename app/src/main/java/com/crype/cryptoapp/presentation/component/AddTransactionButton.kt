package com.crype.cryptoapp.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.cryptoapp.R
import com.crype.cryptoapp.presentation.ui.theme.BackgroundBlock
import com.crype.cryptoapp.presentation.ui.theme.Black
import com.crype.cryptoapp.presentation.ui.theme.Gray
import com.crype.cryptoapp.presentation.ui.theme.SFPro
import com.crype.cryptoapp.presentation.ui.theme.White

@Composable
fun AddTransactionButton(
    onClick: () -> Unit,
    iconSize: Dp,
    spaceBetween:Dp,
    verticalPadding: Dp,
    horizontalPadding: Dp
    ) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = BackgroundBlock
        ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(spaceBetween),
            modifier = Modifier
                .padding(
                    vertical = verticalPadding,
                    horizontal = horizontalPadding
                )
        ) {
            Card(
                modifier = Modifier
                    .size(iconSize),
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors().copy(
                    containerColor = Black,
                    contentColor = White
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
            Text(
                text = stringResource(id = R.string.add_transaction),
                color = Black,
                fontSize = 16.sp,
                fontFamily = SFPro,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}