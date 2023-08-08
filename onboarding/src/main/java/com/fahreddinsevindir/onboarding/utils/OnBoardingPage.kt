package com.fahreddinsevindir.onboarding.utils

import androidx.annotation.RawRes
import androidx.annotation.StringRes
import com.fahreddinsevindir.onboarding.R

sealed class OnBoardingPage(
    @StringRes val title: Int,
    @RawRes val lottie: Int,
    @StringRes val description: Int
) {
    object FirstScreen : OnBoardingPage(
        title = R.string.first_screen_title,
        lottie = R.raw.onboarding_first,
        description = R.string.first_screen_desc,
    )

    object SecondScreen : OnBoardingPage(
        title = R.string.second_screen_title,
        lottie = R.raw.onboarding_second,
        description = R.string.second_screen_desc,
    )


    object ThirdScreen : OnBoardingPage(
        title = R.string.third_screen_title,
        lottie = R.raw.onboarding_third,
        description = R.string.third_screen_desc,
    )


}
