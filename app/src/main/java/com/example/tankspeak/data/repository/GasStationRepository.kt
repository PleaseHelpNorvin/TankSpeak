package com.example.tankspeak.data.repository

import androidx.compose.runtime.mutableStateOf
import com.example.tankspeak.data.model.Fuel
import com.example.tankspeak.data.model.GasStation
import com.example.tankspeak.data.model.TankReading

class GasStationRepository {

    private val gasStations = mutableListOf(
        GasStation(
            id = "1", // temporary string
            name = "Total Station",
            address = "Binalbagan, Negros Occidental",
            manager = "Manuel Yulo",
            contactNumber = "123456789",
            businessHours = "5:30 - 2:000",
            timeStamp = "2029-08-06 18:00",
            fuels = mutableListOf(
                Fuel(
                    id = "1",
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
        )
    )

    fun getGasStations(): List<GasStation> {
        return gasStations
    }

    fun getGasStationById(id: String): GasStation? {
        return gasStations.find { it.id == id }
    }

    fun addGasStation(gasStation: GasStation) {
        gasStations.add(gasStation)
    }

    fun updateGasStation(updatedGasStation: GasStation) {
        val index = gasStations.indexOfFirst { it.id == updatedGasStation.id }
        if (index != -1 ) {
            gasStations[index] = updatedGasStation
        }
    }

    fun deleteGasStation(id: String) {
        gasStations.removeIf { it.id == id }
    }
}