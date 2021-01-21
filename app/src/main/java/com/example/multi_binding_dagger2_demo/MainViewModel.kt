package com.example.multi_binding_dagger2_demo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel constructor(val name: String): ViewModel() {
    private val TAG = "MultiBinding_Dagger2_Demo"
    init {
        Log.d(TAG, "view Model -> name = $name")
    }
}

class MainViewModelFactory(val name: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(name) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}