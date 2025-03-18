package com.crype.cryptoapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crype.cryptoapp.R
import com.crype.cryptoapp.presentation.navigation.Screens
import com.crype.cryptoapp.presentation.ui.theme.BackgroundBlock
import com.crype.cryptoapp.presentation.ui.theme.Black
import com.crype.cryptoapp.presentation.ui.theme.Gray
import com.crype.cryptoapp.presentation.ui.theme.SFCompact
import com.crype.cryptoapp.presentation.ui.theme.White
import com.crype.cryptoapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    currentRoute: String?,
    navController: NavController,
    viewModel: MainViewModel = koinViewModel()
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = White
        ),
        title = {
            currentRoute?.let { route ->
                val screenTitle = when (route) {
                    "coin_detail_screen" -> viewModel.selectedCoin.value.coinName
                    "coin_select_screen" -> stringResource(id = R.string.add_transaction)
                    "add_transaction_screen" -> "Add ${viewModel.selectedCoin.value.coinName} transaction"
                    "settings_screen" -> stringResource(id = R.string.settings)
                    else -> null
                }
                screenTitle?.let { titleRes ->
                    Text(
                        text = titleRes,
                        fontWeight = FontWeight.Medium,
                        fontFamily = SFCompact,
                        fontSize = 20.sp,
                        letterSpacing = 0.sp,
                        color = Gray,
                        textAlign = TextAlign.Center
                    )
                }
            }
        },
        navigationIcon = {
            if (currentRoute == Screens.CoinDetailScreen.route) {
                Box(modifier = Modifier.padding(start = 10.dp)){
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        },
                        colors = IconButtonDefaults.iconButtonColors().copy(
                            containerColor = BackgroundBlock
                        ),
                        modifier = Modifier
                            .background(color = BackgroundBlock, shape = CircleShape)
                            .size(40.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = Black,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }
        }
    )
}