package com.example.tankspeak.data.repository

import com.example.tankspeak.data.source.FakeDataSource
import com.example.tankspeak.data.model.TankReading
import com.example.tankspeak.data.model.Fuel

class TankReadingRepository {

    fun addReading(
        gasStationId: String,
        fuelId: String,
        reading: TankReading
    ): Boolean {
        val fuel = findFuel(gasStationId, fuelId) ?: return false
        val currentReadings = fuel.readings ?: emptyList()
        fuel.readings = currentReadings + reading
        return true
    }

    fun getReadings(
        gasStationId: String,
        fuelId: String
    ): List<TankReading> {
        return findFuel(gasStationId, fuelId)?.readings ?: emptyList()
    }

    fun updateReading(
        gasStationId: String,
        fuelId: String,
        readingId: String,
        updated: TankReading
    ): Boolean {
        val fuel = findFuel(gasStationId, fuelId) ?: return false
        val currentReadings = fuel.readings ?: return false

        val newReadings = currentReadings.map {
            if (it.id == readingId) updated else it
        }

        fuel.readings = newReadings
        return true
    }

    fun deleteReading(
        gasStationId: String,
        fuelId: String,
        readingId: String
    ): Boolean {
        val fuel = findFuel(gasStationId, fuelId) ?: return false
        val currentReadings = fuel.readings ?: return false

        fuel.readings = currentReadings.filterNot { it.id == readingId }
        return true
    }

    private fun findFuel(gasStationId: String, fuelId: String): Fuel? {
        return FakeDataSource.gasStations
            .find { it.id == gasStationId }
            ?.fuels
            ?.find { it.id == fuelId }
    }
}