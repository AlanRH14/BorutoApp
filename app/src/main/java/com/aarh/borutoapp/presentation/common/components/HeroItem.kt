package com.aarh.borutoapp.presentation.common.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.aarh.borutoapp.R
import com.aarh.borutoapp.data.mockdata.HeroProvider
import com.aarh.borutoapp.data.mockdata.HeroProvider.hero1
import com.aarh.borutoapp.domain.entity.Hero
import com.aarh.borutoapp.presentation.screens.home.widgets.RatingWidget
import com.aarh.borutoapp.ui.theme.HERO_ITEM_HEIGHT
import com.aarh.borutoapp.ui.theme.LARGE_PADDING
import com.aarh.borutoapp.ui.theme.MEDIUM_PADDING
import com.aarh.borutoapp.ui.theme.MIN_PADDING
import com.aarh.borutoapp.ui.theme.SMALL_PADDING
import com.aarh.borutoapp.ui.theme.TopBarContentColor
import com.aarh.borutoapp.util.Constants.BASE_URL

@Composable
fun HeroItem(
    navController: NavHostController,
    hero: Hero,
) {
    val mContext = LocalContext.current

    Box(
        modifier = Modifier
            .height(HERO_ITEM_HEIGHT),
        contentAlignment = Alignment.BottomStart,
    ) {
        Surface(
            shape = RoundedCornerShape(size = LARGE_PADDING),
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize(),
                model = ImageRequest
                    .Builder(mContext)
                    .data("$BASE_URL${hero.image}")
                    .error(R.drawable.ic_placeholder)
                    .placeholder(R.drawable.ic_placeholder)
                    .build(),
                contentDescription = stringResource(R.string.hero_image_content_description),
                contentScale = ContentScale.Crop,
            )
        }

        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4F)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING,
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = MEDIUM_PADDING),
            ) {
                Text(
                    text = hero.name,
                    color = TopBarContentColor,
                    fontSize = typography.h4.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Text(
                    modifier = Modifier
                        .padding(vertical = MIN_PADDING),
                    text = hero.about,
                    color = Color.White.copy(alpha = ContentAlpha.medium),
                    fontSize = typography.subtitle1.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                )

                Row(
                    modifier = Modifier
                        .padding(end = SMALL_PADDING),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    RatingWidget(
                        modifier = Modifier
                            .padding(end = SMALL_PADDING),
                        rating = hero.rating,
                    )

                    Text(
                        text = "(${hero.rating})",
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = ContentAlpha.medium),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HeroItemPreview() {
    HeroItem(
        navController = rememberNavController(),
        hero = hero1,
    )
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HeroItemDarkPreview() {
    HeroItem(
        navController = rememberNavController(),
        hero = hero1,
    )
}
