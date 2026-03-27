package com.example.tankspeak.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.example.tankspeak.ui.global.GlobalViewModel
import androidx.compose.material3.Button
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tankspeak.ui.models.MainViewModel
import com.example.tankspeak.ui.navigation.Screen

@Composable
fun MainScreen(
    navController: NavController,
    globalViewModel: GlobalViewModel
) {
    val viewModel: MainViewModel = viewModel()
    val tankStatus = viewModel.tankStatus.collectAsState()

    Column {
        Text("Main Screen")
        Text("Tank Level: ${tankStatus.value.level}")

        Button(
            onClick = {
                navController.navigate(Screen.Another.route)
            }
        ) {
            Text("Go to AnotherScreen ")
        }

        Button(onClick = {
            globalViewModel.toggleDarkMode()
        }) {
            Text("Toggle Dark Mode")
        }
    }
}