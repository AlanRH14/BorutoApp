package com.aarh.borutoapp

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.aarh.borutoapp.navigation.SetupNavGraph
import com.aarh.borutoapp.ui.theme.BorutoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setOnExitAnimationListener { splashScreenView ->
                val rotation = ObjectAnimator.ofFloat(
                    splashScreenView.iconView,
                    View.ROTATION,
                    0F,
                    360F
                )

                rotation.apply {
                    duration = 1000
                    interpolator = AccelerateDecelerateInterpolator()

                    doOnEnd {
                        splashScreenView.remove()
                    }

                    start()
                }
            }
        }

        setContent {
            BorutoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    SetupNavGraph(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
