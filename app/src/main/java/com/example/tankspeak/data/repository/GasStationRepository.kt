package com.example.tankspeak.data.repository

import com.example.tankspeak.data.model.GasStation
import com.example.tankspeak.data.source.FakeDataSource

class GasStationRepository {

    fun getGasStations(): List<GasStation> {
        return FakeDataSource.gasStations
    }

    fun getGasStationById(id: String): GasStation? {
        return FakeDataSource.gasStations.find { it.id == id }
    }

    fun addGasStation(gasStation: GasStation): Boolean {
        FakeDataSource.gasStations.add(gasStation)
        return true
    }

    fun updateGasStation(updatedGasStation: GasStation): Boolean {
        val index = FakeDataSource.gasStations
            .indexOfFirst { it.id == updatedGasStation.id }

        return if (index != -1) {
            FakeDataSource.gasStations[index] = updatedGasStation
            true
        } else false
    }

    fun deleteGasStation(id: String): Boolean {
        return FakeDataSource.gasStations.removeIf { it.id == id }
    }
}