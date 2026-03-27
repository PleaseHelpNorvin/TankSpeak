package com.example.tankspeak.data.repository

import com.example.tankspeak.data.model.TankStatus

class TankRepository {

    fun getCurrentStatus(): TankStatus {
        return TankStatus(level = 75, isFilling = true)
    }
}