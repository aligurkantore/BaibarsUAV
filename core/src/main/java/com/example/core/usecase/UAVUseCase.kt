package com.example.core.usecase

import com.example.core.model.UAVData
import com.example.core.repository.UAVRepository
import kotlinx.coroutines.flow.Flow

class UAVUseCase(private val repository: UAVRepository) {
    fun execute(): Flow<UAVData> = repository.startDataFlow()
}