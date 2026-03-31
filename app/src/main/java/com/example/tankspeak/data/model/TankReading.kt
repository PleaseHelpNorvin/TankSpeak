package com.example.tankspeak.data.model


data class TankReading(
    val id: String,
    val tankName: String,
    val volume: Double,
    val timeStamp: String,
    val addedVolume: Double?
)
