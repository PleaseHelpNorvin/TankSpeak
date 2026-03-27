package com.example.tankspeak.ui.navigation

sealed class Screen(val route: String) {

    object  Main : Screen("main")
    object Another : Screen("another")
}