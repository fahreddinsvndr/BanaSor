package com.fahreddinsevindir.banasor.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fahreddinsevindir.onboarding.OnBoardingScreen
import com.fahreddinsevindir.splash.SplashScreen

@Composable
fun NavGraph(navController: NavHostController, paddingValues: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        modifier = Modifier.padding(paddingValues = paddingValues)

    ) {

        composable(route = Screen.Splash.route) {
            SplashScreen(
                navigateToOnboardingScreen = {
                    navController.navigate(Screen.OnBoarding.route){
                        popUpTo(Screen.Splash.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(route = Screen.OnBoarding.route) {
            OnBoardingScreen(
                popBackStack = {
                    navController.popBackStack()
                }
            )
        }


    }
}
