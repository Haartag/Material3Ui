package com.example.material3ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object MainScreen: Screen("main")
    object ButtonsScreen: Screen("buttons")
}

@Composable
fun MainNavigation() {
    val mainNavController = rememberNavController()
    NavHost(navController = mainNavController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) {
            MainScreen(mainNavController = mainNavController)
        }
        composable(Screen.ButtonsScreen.route) {
            ButtonsScreen(mainNavController = mainNavController)
        }
    }
}