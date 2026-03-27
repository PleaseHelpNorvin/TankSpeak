package com.example.tankspeak.data.model


data class TankReading(
    val tankName: String, // temporary string
    val volume: Double,
    val timeStamp: String,
    val addedVolume: Double?
)
