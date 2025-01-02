package com.aarh.borutoapp.util.error

import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.presentation.common.widgets.ShimmerEffect

@Composable
fun handlerPagingResult(
    heroes: LazyPagingItems<Hero>,
): Boolean {
    heroes.apply {
        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }

        return when {
            loadState.refresh is LoadState.Loading -> {
                ShimmerEffect()
                false
            }

            error != null -> {
                false
            }

            else -> {
                true
            }
        }
    }
}
