package com.fahreddinsevindir.onboarding.componets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fahreddinsevindir.onboarding.R

@Composable
fun OnBoardingTopSection(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onSkipClick: () -> Unit = {},
    isSkipVisible: Boolean,
    isBackVisible: Boolean,
    size: Int,
    index: Int
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        if (isBackVisible) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = null
                )
            }
        }

        Indicators(size = size, index = index)

        if (isSkipVisible) {
            TextButton(
                onClick = onSkipClick,
                modifier = Modifier.align(Alignment.CenterEnd),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(text = stringResource(id = R.string.next))
            }
        }
    }
}