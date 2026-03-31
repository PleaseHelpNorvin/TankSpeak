package com.example.tankspeak.data.model

data class GasStation(
    val id: String, // temporary string
    val name: String,
    val address: String,
    val manager: String,
    val contactNumber: String,
    val businessHours: String,
    val timeStamp: String,
    var fuels: MutableList<Fuel>
)
