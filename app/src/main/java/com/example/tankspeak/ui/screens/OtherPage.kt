package com.example.tankspeak.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.navigation.NavController
import com.example.tankspeak.ui.navigation.Screen

@Composable
fun AnotherScreen(
    navController: NavController,
) {
    Column {
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate(Screen.Main.route)
        }) {
            Text("Go to Main ")
        }
    }
}

