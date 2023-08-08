package com.fahreddinsevindir.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.fahreddinsevindir.onboarding.componets.CustomBottomSection
import com.fahreddinsevindir.onboarding.componets.CustomOnBoardingButton
import com.fahreddinsevindir.onboarding.componets.OnBoardingTopSection
import com.fahreddinsevindir.onboarding.componets.PagerScreen
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = hiltViewModel(),
    popBackStack: () -> Unit,
) {
    val pager = viewModel.pager
    val state = rememberPagerState()
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp)
    ) {

        OnBoardingTopSection(
            modifier = Modifier.weight(1f),
            size = pager.size,
            index = state.currentPage,
            onBackClick = {
                if (state.currentPage + 1 > 1) scope.launch {
                    state.scrollToPage(state.currentPage - 1)
                }
            },
            onSkipClick = {
                if (state.currentPage + 1 < pager.size) scope.launch {
                    state.scrollToPage(pager.size - 1)
                }
            },
            isSkipVisible = state.currentPage != 2,
            isBackVisible = state.currentPage >= 1
        )

        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = 3,
            state = state,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pager[position])
        }


        AnimatedVisibility(
            visible = state.currentPage != 2
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Bottom,
                horizontalArrangement = Arrangement.End
            ) {
                CustomBottomSection {
                    if (state.currentPage + 1 < pager.size) scope.launch {
                        state.scrollToPage(state.currentPage + 1)
                    }
                }
            }
        }

        CustomOnBoardingButton(
            pagerState = state
        ) {
            popBackStack()
        }

    }


}
