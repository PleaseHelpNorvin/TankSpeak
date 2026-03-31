package com.example.tankspeak.data.repository

import com.example.tankspeak.data.model.Fuel
import com.example.tankspeak.data.source.FakeDataSource

class FuelRepository {

    fun getFuels(): List<Fuel> {
        return FakeDataSource.gasStations.flatMap { it.fuels }
    }

    fun getFuelsByGasStation(gasStationId: String): List<Fuel> {
        return FakeDataSource.gasStations
            .find { it.id == gasStationId }
            ?.fuels ?: emptyList()
    }

    fun getFuelById(gasStationId: String, fuelId: String): Fuel? {
        return FakeDataSource.gasStations
            .find { it.id == gasStationId }
            ?.fuels
            ?.find { it.id == fuelId }
    }

    fun addFuel(gasStationId: String, fuel: Fuel): Boolean {
        val station = FakeDataSource.gasStations.find { it.id == gasStationId }
            ?: return false

        val mutableFuels = station.fuels.toMutableList()
        mutableFuels.add(fuel)

        // replace immutable list
        station.fuels = mutableFuels

        return true
    }

    fun updateFuel(gasStationId: String, updatedFuel: Fuel): Boolean {
        val station = FakeDataSource.gasStations.find { it.id == gasStationId }
            ?: return false

        val mutableFuels = station.fuels.toMutableList()
        val index = mutableFuels.indexOfFirst { it.id == updatedFuel.id }

        return if (index != -1) {
            mutableFuels[index] = updatedFuel
            station.fuels = mutableFuels
            true
        } else false
    }

    fun deleteFuel(gasStationId: String, fuelId: String): Boolean {
        val station = FakeDataSource.gasStations.find { it.id == gasStationId }
            ?: return false

        val mutableFuels = station.fuels.toMutableList()
        val removed = mutableFuels.removeIf { it.id == fuelId }

        station.fuels = mutableFuels
        return removed
    }
}