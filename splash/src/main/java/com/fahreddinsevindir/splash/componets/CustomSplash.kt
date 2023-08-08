package com.fahreddinsevindir.splash.componets

import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun CustomSplash(
    modifier: Modifier,
    @RawRes resources: Int
) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(resources))
    val progress by animateLottieCompositionAsState(composition = composition)



    LottieAnimation(
        composition = composition,
        progress = progress,
        modifier = modifier,
    )
}