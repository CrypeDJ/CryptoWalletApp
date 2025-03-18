package com.crype.cryptoapp.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crype.cryptoapp.R
import com.crype.cryptoapp.presentation.component.EnterValue
import com.crype.cryptoapp.presentation.component.MainButton
import com.crype.cryptoapp.presentation.component.PriceField
import com.crype.cryptoapp.presentation.navigation.Screens
import com.crype.cryptoapp.presentation.ui.theme.BackgroundBlock
import com.crype.cryptoapp.presentation.ui.theme.Black
import com.crype.cryptoapp.presentation.ui.theme.Blue
import com.crype.cryptoapp.presentation.ui.theme.DisableBlue
import com.crype.cryptoapp.presentation.ui.theme.HalfTransparent
import com.crype.cryptoapp.presentation.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTransactionScreen(
    navController: NavController
) {
    var value by remember {
        mutableStateOf("")
    }
    var price by remember {
        mutableStateOf("")
    }
    var isBottomSheet by remember {
        mutableStateOf(false)
    }
    val focusRequester = remember { FocusRequester() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            EnterValue(
                fontSize = 52.sp,
                value = value,
                modifier = Modifier.focusRequester(focusRequester)
            ) {
                value = it
            }
            MainButton(
                containerColor = BackgroundBlock,
                disabledContainerColor = BackgroundBlock,
                textColor = Black,
                enabled = true,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .height(33.dp),
                text = stringResource(id = R.string.price_coin),
                verticalPadding = 0.dp,
                horizontalPadding = 0.dp
            ) {
                isBottomSheet = true
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(vertical = 25.dp)
        ) {
            MainButton(
                containerColor = BackgroundBlock,
                disabledContainerColor = BackgroundBlock,
                textColor = Blue,
                enabled = true,
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.cansel),
                verticalPadding = 8.dp,
                horizontalPadding = 0.dp
            ) {
                navController.popBackStack()
            }
            MainButton(
                containerColor = Blue,
                disabledContainerColor = DisableBlue,
                textColor = White,
                enabled = value.isNotEmpty(),
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.add),
                verticalPadding = 8.dp,
                horizontalPadding = 0.dp
            ) {
                navController.navigate(route = Screens.HomeScreen.route)
            }
        }
    }
    if (isBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { isBottomSheet = false },
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            containerColor = White,
            scrimColor = HalfTransparent,
            modifier = Modifier.imePadding(),
        ) {
            LaunchedEffect(Unit) {
                focusRequester.requestFocus() // Автоматически открывает клавиатуру
            }
            PriceField(
                value = price,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
            ) {
                price = it
            }
            Box(modifier = Modifier.padding(vertical = 20.dp)) {
                MainButton(
                    containerColor = Blue,
                    disabledContainerColor = DisableBlue,
                    textColor = White,
                    enabled = price.isNotEmpty(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    text = stringResource(id = R.string.set_price),
                    verticalPadding = 8.dp,
                    horizontalPadding = 0.dp
                ) {
                    isBottomSheet = false
                }
            }
        }
    }
}
