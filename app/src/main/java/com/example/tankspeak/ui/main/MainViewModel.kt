package com.example.tankspeak.ui.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tankspeak.data.model.TankStatus
import com.example.tankspeak.data.repository.TankRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val tankRepository: TankRepository = TankRepository()
) : ViewModel() {
    private val _tankStatus = MutableStateFlow(TankStatus())
    val tankStatus: StateFlow<TankStatus> = _tankStatus

    init {
        viewModelScope.launch {
            val status = tankRepository.getCurrentStatus()
            _tankStatus.value = status
        }
    }
}