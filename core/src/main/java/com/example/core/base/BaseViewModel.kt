package com.example.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    protected fun <T> Flow<T>.collectFlow(
        stateFlow: MutableStateFlow<T>
    ) {
        viewModelScope.launch {
            this@collectFlow
                .onStart { _loading.value = true }
                .catch { _error.value = it.message }
                .onCompletion { _loading.value = false }
                .collect { stateFlow.value = it }
        }
    }
}
