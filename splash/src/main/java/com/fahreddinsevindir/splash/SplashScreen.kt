package com.fahreddinsevindir.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.fahreddinsevindir.splash.componets.CustomSplash

@Composable
fun SplashScreen(
    navigateToOnboardingScreen: () -> Unit
) {
    val composition: LottieCompositionResult =
        rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash))
    val progress by animateLottieCompositionAsState(
        composition.value,
        iterations = 1,
    )

    LaunchedEffect(progress) {
        if (progress >= 1f) {
            navigateToOnboardingScreen.invoke()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        CustomSplash(modifier = Modifier, resources = R.raw.splash)
    }


}