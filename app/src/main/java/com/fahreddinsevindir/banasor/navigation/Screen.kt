package com.fahreddinsevindir.banasor.navigation

sealed class Screen(val route: String) {

    object Splash : Screen("splash_screen")

    object OnBoarding:Screen("onboarding_screen")
}