package com.example.core.repository

import com.example.core.model.UAVData
import kotlinx.coroutines.flow.Flow

interface UAVRepository {
    fun startDataFlow(): Flow<UAVData>
}