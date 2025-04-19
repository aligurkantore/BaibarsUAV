package com.example.core.data

import com.example.core.model.UAVData
import com.example.core.repository.UAVRepository
import com.example.core.utils.formatToTwoDecimalPlaces
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Locale
import kotlin.random.Random

class DataRepository : UAVRepository {

    private var flightSeconds = 58
    private var batteryVoltage = 16.5f

    override fun startDataFlow(): Flow<UAVData> = flow {
        var lastSensorUpdateTime = 0L
        var currentAltitude = (100..150).random()
        var currentLatitude = 41.015137 + Random.nextDouble(-0.01, 0.01)
        var currentLongitude = 28.979530 + Random.nextDouble(-0.01, 0.01)
        var currentBattery = batteryVoltage

        while (true) {
            val currentTime = System.currentTimeMillis()

            if (currentTime - lastSensorUpdateTime >= 5000L) {
                currentBattery = (currentBattery - Random.nextFloat() * 0.05f).coerceAtLeast(12.0f)
                currentAltitude = (10..25).random()

                currentLatitude = String.format(Locale.US, "%.4f", 36.8121 + Random.nextDouble(-0.01, 0.01)).toDouble()
                currentLongitude = String.format(Locale.US, "%.4f", 34.6415 + Random.nextDouble(-0.01, 0.01)).toDouble()

                lastSensorUpdateTime = currentTime
            }

            val formattedBatteryVoltage = currentBattery.formatToTwoDecimalPlaces()

            val data = UAVData(
                batteryVoltage = formattedBatteryVoltage.toFloat(),
                altitude = currentAltitude,
                gpsLatitude = currentLatitude,
                gpsLongitude = currentLongitude,
                flightTime = formatTime(flightSeconds++)
            )

            emit(data)
            delay(1000L)
        }
    }



    private fun formatTime(seconds: Int): String {
        val hrs = seconds / 3600
        val min = (seconds % 3600) / 60
        val sec = seconds % 60
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", hrs, min, sec)
    }
}
