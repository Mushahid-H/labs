package com.example.lab_exam

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splashScreen")
    object qScreen : Screen("questionScreen")

    object ResultScreen : Screen("resultScreen")
    // Add other screens here
}