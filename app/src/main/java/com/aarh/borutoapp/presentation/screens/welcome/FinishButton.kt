package com.aarh.borutoapp.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.aarh.borutoapp.R
import com.aarh.borutoapp.ui.theme.PurpleUIModeColor
import com.aarh.borutoapp.ui.theme.EXTRA_LARGE_PADDING
import com.aarh.borutoapp.ui.theme.SMALL_PADDING

@ExperimentalFoundationApi
@Composable
fun FinisButton(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .padding(horizontal = EXTRA_LARGE_PADDING),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AnimatedVisibility(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = EXTRA_LARGE_PADDING,
                    vertical = SMALL_PADDING,
                ),
            visible = pagerState.currentPage == pagerState.pageCount - 1,
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = PurpleUIModeColor,
                    contentColor = Color.White,
                ),
                onClick = { onClick.invoke() },
            ) {
                Text(text = stringResource(R.string.btn_finish))
            }
        }
    }
}
