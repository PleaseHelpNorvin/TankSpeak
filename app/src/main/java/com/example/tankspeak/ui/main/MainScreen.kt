package com.example.tankspeak.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(mainViewModel: MainViewModel = viewModel()) {
    val tankStatus = mainViewModel.tankStatus.collectAsState()
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Tank Level: ${tankStatus.value.level}")
        Text("Is Filling: ${tankStatus.value.isFilling}")
    }
}