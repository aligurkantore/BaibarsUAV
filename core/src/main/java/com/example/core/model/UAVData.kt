package com.example.core.model

data class UAVData(
    val batteryVoltage: Float,
    val altitude: Int,
    val gpsLatitude: Double,
    val gpsLongitude: Double,
    val flightTime: String
)
