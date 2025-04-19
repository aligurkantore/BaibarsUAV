package com.example.baibarsuav.ui.main

import com.example.core.base.BaseViewModel
import com.example.core.usecase.UAVUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val uavUseCase: UAVUseCase): BaseViewModel()