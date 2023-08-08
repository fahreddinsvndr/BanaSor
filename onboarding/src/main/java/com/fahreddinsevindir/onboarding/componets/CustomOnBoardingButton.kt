package com.fahreddinsevindir.onboarding.componets

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fahreddinsevindir.onboarding.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomOnBoardingButton(
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.SemiBold,
    pagerState: PagerState,
    onClick: () -> Unit,
) {
    AnimatedVisibility(
        visible = pagerState.currentPage == 2
    ) {
        Row(
            modifier = modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { onClick() },
                modifier = modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.lets_start),
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = fontWeight
                )
            }
        }
    }
}