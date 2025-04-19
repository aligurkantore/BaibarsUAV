package com.example.features.ui.uav

import com.example.core.base.BaseViewModel
import com.example.core.model.UAVData
import com.example.core.usecase.UAVUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class UAVViewModel @Inject constructor(private val uavUseCase: UAVUseCase): BaseViewModel() {
    private val _uavData = MutableStateFlow<UAVData?>(null)
    val uavData: StateFlow<UAVData?> = _uavData

    init {
        startDataFlow()
    }

    private fun startDataFlow() {
        uavUseCase.execute().collectFlow(_uavData)
    }
}