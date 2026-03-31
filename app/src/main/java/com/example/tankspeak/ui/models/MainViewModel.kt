package com.example.tankspeak.ui.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tankspeak.data.model.Fuel
import com.example.tankspeak.data.model.GasStation
import com.example.tankspeak.data.model.TankReading
import com.example.tankspeak.data.repository.FuelRepository
import com.example.tankspeak.data.repository.GasStationRepository
import com.example.tankspeak.data.repository.TankReadingRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


data class GasStationUIState(
    val gasStations: List<GasStation> = emptyList(),
    val selectedFuels: List<Fuel> = emptyList(),
    val selectedReadings: List<TankReading> = emptyList()
)

class MainViewModel(
    private val gasStationRepository: GasStationRepository = GasStationRepository(),
    private val fuelRepository: FuelRepository = FuelRepository(),
    private val tankReadingRepository: TankReadingRepository = TankReadingRepository()
) : ViewModel() {
    private val _uiState = MutableStateFlow(GasStationUIState())
    val uiState: StateFlow<GasStationUIState> = _uiState


    init {
        viewModelScope.launch {
            loadGasStations()
        }
    }

    private fun loadGasStations() {
        viewModelScope.launch {
            val stations = gasStationRepository.getGasStations()
            _uiState.value = _uiState.value.copy(gasStations = stations)
        }
    }

    fun loadFuels(gasStationId: String) {
        viewModelScope.launch {
            val fuels = fuelRepository.getFuelsByGasStation(gasStationId)
            _uiState.value = _uiState.value.copy(selectedFuels = fuels)
        }
    }

    fun loadReadings(gasStationId: String, fuelId: String) {
        viewModelScope.launch {
            val readings = tankReadingRepository.getReadings(gasStationId, fuelId)
            _uiState.value = _uiState.value.copy(selectedReadings = readings)
        }
    }

    fun addReading(gasStationId: String, fuelId: String, reading: TankReading) {
        viewModelScope.launch {
            val success = tankReadingRepository.addReading(gasStationId, fuelId, reading)
            if (success) {
                loadReadings(gasStationId, fuelId)
            }
        }
    }

}