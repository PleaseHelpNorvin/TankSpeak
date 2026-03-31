package com.example.tankspeak.data.repository

import com.example.tankspeak.data.model.Fuel
import com.example.tankspeak.data.source.FakeDataSource

class FuelRepository {

    fun getFuels(): MutableList<Fuel> {
        return FakeDataSource.gasStations.flatMap { it.fuels }.toMutableList()
    }

    fun getFuelsByGasStation(gasStationId: String): MutableList<Fuel> {
        return FakeDataSource.gasStations
            .find { it.id == gasStationId }
            ?.fuels?.toMutableList() ?: mutableListOf()
    }

    fun getFuelById(gasStationId: String, fuelId: String): Fuel? {
        return FakeDataSource.gasStations
            .find { it.id == gasStationId }
            ?.fuels
            ?.find { it.id == fuelId }
    }

    fun addFuel(gasStationId: String, fuel: Fuel): Boolean {
        val station = FakeDataSource.gasStations.find { it.id == gasStationId } ?: return false

        val mutableFuels = station.fuels.toMutableList()
        mutableFuels.add(fuel)
        station.fuels = mutableFuels

        return true
    }

    fun updateFuel(gasStationId: String, updatedFuel: Fuel): Boolean {
        val station = FakeDataSource.gasStations.find { it.id == gasStationId } ?: return false

        val mutableFuels = station.fuels.toMutableList()
        val index = mutableFuels.indexOfFirst { it.id == updatedFuel.id }

        return if (index != -1) {
            mutableFuels[index] = updatedFuel
            station.fuels = mutableFuels
            true
        } else false
    }

    fun deleteFuel(gasStationId: String, fuelId: String): Boolean {
        val station = FakeDataSource.gasStations.find { it.id == gasStationId } ?: return false

        val mutableFuels = station.fuels.toMutableList()
        val removed = mutableFuels.removeIf { it.id == fuelId }
        station.fuels = mutableFuels

        return removed
    }
}