package com.example.core.di

import com.example.core.data.DataRepository
import com.example.core.repository.UAVRepository
import com.example.core.usecase.UAVUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UAVModule {

    @Provides
    @Singleton
    fun provideUAVRepository(): UAVRepository {
        return DataRepository()
    }

    @Provides
    @Singleton
    fun provideUAVUseCase(repository: UAVRepository): UAVUseCase {
        return UAVUseCase(repository)
    }
}