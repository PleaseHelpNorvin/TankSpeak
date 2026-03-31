package com.example.tankspeak.data.model

data class Fuel(
    val id: String, // temporary string
    val name: String,
    val tankCapacity: Double,
    val averageThroughput : Double,
    val anticipatedDryUp: String,
    val fillAlert: String,
    val timeStamp: String,
    var readings: List<TankReading>?
)
