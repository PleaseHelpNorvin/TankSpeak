package com.example.tankspeak.ui.global

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class GlobalViewModel : ViewModel() {
    val darkModeEnabled = mutableStateOf(false)

    fun toggleDarkMode() {
        darkModeEnabled.value = !darkModeEnabled.value
    }
}
