package com.aarh.borutoapp.presentation.screens.welcome.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.aarh.borutoapp.R
import com.aarh.borutoapp.domain.model.OnBoardingPage
import com.aarh.borutoapp.ui.theme.DescriptionColor
import com.aarh.borutoapp.ui.theme.EXTRA_LARGE_PADDING
import com.aarh.borutoapp.ui.theme.SMALL_PADDING
import com.aarh.borutoapp.ui.theme.GraySystemUIColor

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .fillMaxHeight(0.7F),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = stringResource(
                R.string.on_boarding_image,
            ),
        )
        Text(
            text = onBoardingPage.title,
            color = GraySystemUIColor,
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
        )
        Text(
            modifier = Modifier
                .padding(
                    top = SMALL_PADDING,
                    start = EXTRA_LARGE_PADDING,
                    end = EXTRA_LARGE_PADDING
                )
                .fillMaxWidth(),
            text = onBoardingPage.description,
            color = DescriptionColor,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
        )
    }
}

@ExperimentalFoundationApi
@Composable
@Preview(showBackground = true)
fun FirstOnBoardingScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        PagerScreen(onBoardingPage = OnBoardingPage.FirstPage)
    }
}

@ExperimentalFoundationApi
@Composable
@Preview(showBackground = true)
fun SecondOnBoardingScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        PagerScreen(onBoardingPage = OnBoardingPage.SecondPage)
    }
}

@ExperimentalFoundationApi
@Composable
@Preview(showBackground = true)
fun ThirdOnBoardingScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        PagerScreen(onBoardingPage = OnBoardingPage.ThirdPage)
    }
}
