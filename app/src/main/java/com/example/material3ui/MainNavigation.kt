package com.example.material3ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object MainScreen: Screen("main")
    object ButtonsScreen: Screen("buttons")
    object TextFieldsScreen: Screen("text_fields")
    object SelectionScreen: Screen("selection")
    object TopAppBarScreen: Screen("top_app_bar")
    object BottomAppBarScreen: Screen("bottom_app_bar")
    object BottomNavigationBarScreen: Screen("bottom_navigation_bar")
    object SwipeableTabRowsScreen: Screen("swipeable_tab_rows")
    object BottomSheetScreen: Screen("bottom_sheet")
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
        composable(Screen.TextFieldsScreen.route) {
            TextFieldsScreen(mainNavController = mainNavController)
        }
        composable(Screen.SelectionScreen.route) {
            SelectionScreen(mainNavController = mainNavController)
        }
        composable(Screen.TopAppBarScreen.route) {
            TopAppBarScreen(mainNavController = mainNavController)
        }
        composable(Screen.BottomAppBarScreen.route) {
            BottomAppBarScreen(mainNavController = mainNavController)
        }
        composable(Screen.BottomNavigationBarScreen.route) {
            BottomNavigationBarScreen(mainNavController = mainNavController)
        }
        composable(Screen.SwipeableTabRowsScreen.route) {
            SwipeableTabRowsScreen(mainNavController = mainNavController)
        }
        composable(Screen.BottomSheetScreen.route) {
            BottomSheetScreen(mainNavController = mainNavController)
        }
    }
}