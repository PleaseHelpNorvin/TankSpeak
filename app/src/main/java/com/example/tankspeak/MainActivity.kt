package com.example.tankspeak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*

import com.example.tankspeak.ui.theme.TankSpeakTheme
import com.example.tankspeak.ui.screens.MainScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tankspeak.ui.global.GlobalViewModel
import com.example.tankspeak.ui.navigation.Screen
import com.example.tankspeak.ui.screens.AnotherScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val globalViewModel: GlobalViewModel = viewModel()

            val isDarkMode = globalViewModel.darkModeEnabled

            TankSpeakTheme(darkTheme = isDarkMode.value) {
                Navigation(globalViewModel)
            }
        }
    }
}

@Composable
fun Navigation(globalViewModel: GlobalViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {

        composable(Screen.Main.route) {
            MainScreen(navController, globalViewModel)
        }

        composable(Screen.Another.route) {
            AnotherScreen(navController)
        }
    }
}


