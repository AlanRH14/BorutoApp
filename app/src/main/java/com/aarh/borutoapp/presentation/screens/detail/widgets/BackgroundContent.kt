package com.aarh.borutoapp.presentation.screens.detail.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.error
import coil3.request.placeholder
import com.aarh.borutoapp.R
import com.aarh.borutoapp.ui.theme.ICON_SIZE
import com.aarh.borutoapp.util.Constants.BASE_URL

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackgroundContent(
    heroImage: String,
    imageFraction: Float = 1F,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    onCloseClicked: () -> Unit
) {
    val imageUrl = "$BASE_URL$heroImage"
    val mContext = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = imageFraction)
                .align(Alignment.TopStart),
            model = ImageRequest
                .Builder(mContext)
                .data(imageUrl)
                .error(R.drawable.ic_placeholder)
                .placeholder(R.drawable.ic_placeholder)
                .build(),
            contentDescription = stringResource(R.string.hero_image_content_description),
            contentScale = ContentScale.Crop,
        )

        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            title = {},
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            ),
            actions = {
                IconButton(onClick = onCloseClicked) {
                    Icon(
                        modifier = Modifier
                            .size(ICON_SIZE),
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.close_icon),
                        tint = Color.White
                    )
                }
            }
        )
    }
}