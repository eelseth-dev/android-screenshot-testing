package com.example.screenshottesting

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    val effect : MutableSharedFlow<String> = MutableSharedFlow()

    init {
        Log.i("algarazam", "viewModel created")
        viewModelScope.launch {
            effect.emit("Create")
        }
    }

    override fun onCleared() {
        super.onCleared()

        Log.i("algarazam", "viewModel cleared")
        viewModelScope.launch {
            effect.emit("Destroy")
        }
    }

}