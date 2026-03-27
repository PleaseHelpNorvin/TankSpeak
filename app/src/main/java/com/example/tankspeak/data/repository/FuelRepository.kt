package com.example.tankspeak.data.repository

import com.example.tankspeak.data.model.Fuel
import com.example.tankspeak.data.model.TankReading
import java.sql.Timestamp


class FuelRepository {
    private val fuels = mutableListOf(
        Fuel(
            id = "1", // temporary string
            name = "Biodiesel",
            tankCapacity = 5000.0,
            averageThroughput = 300.0,
            anticipatedDryUp = "2029-08-07 10:00",
            fillAlert = "2029-08-06 18:00",
            timeStamp = "2029-08-06 18:00",
            readings = mutableListOf(
                TankReading(
                    tankName = "Tank 1",
                    volume = 2227.40,
                    timeStamp = "14:45:15 (06-08-2029)",
                    addedVolume = 1900.0
                )
            )
        )
    )

    fun getFuels(): List<Fuel> {
        return fuels
    }

    fun getFuelById(id: String): Fuel? {
        return fuels.find { it.id == id }
    }

    fun addFuel(fuel: Fuel) {
        fuels.add(fuel)
    }

    fun updateFuel(updatedFuel: Fuel) {
        val index = fuels.indexOfFirst { it.id == updatedFuel.id }
        if (index != -1) {
            fuels[index] = updatedFuel
        }
    }

    fun deleteFuel(id: String) {
        fuels.removeIf { it.id == id }
    }

}