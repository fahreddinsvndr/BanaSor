package com.fahreddinsevindir.onboarding

import androidx.lifecycle.ViewModel
import com.fahreddinsevindir.onboarding.utils.OnBoardingPage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
) : ViewModel() {


    val pager = listOf(
        OnBoardingPage.FirstScreen,
        OnBoardingPage.SecondScreen,
        OnBoardingPage.ThirdScreen,
    )

}