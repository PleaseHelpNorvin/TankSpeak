package com.example.tankspeak.data.source

import com.example.tankspeak.data.model.*

object FakeDataSource {

    val gasStations = mutableListOf(
        GasStation(
            id = "1",
            name = "Shell Mabolo",
            address = "Cebu City",
            manager = "John Doe",
            contactNumber = "09123456789",
            businessHours = "6AM - 10PM",
            timeStamp = "2029-08-06",
            fuels = mutableListOf(
                Fuel(
                    id = "1",
                    name = "Biodiesel",
                    tankCapacity = 5000.0,
                    averageThroughput = 300.0,
                    anticipatedDryUp = "2029-08-07 10:00",
                    fillAlert = "2029-08-06 18:00",
                    timeStamp = "2029-08-06 18:00",
                    readings = listOf(
                        TankReading(
                            id = "1",
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
}