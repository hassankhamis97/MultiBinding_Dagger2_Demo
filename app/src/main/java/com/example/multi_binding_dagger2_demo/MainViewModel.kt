package com.example.multi_binding_dagger2_demo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.multi_binding_dagger2_demo.di.StringProvider

class MainViewModel constructor(val provider: StringProvider): ViewModel() {
    private val TAG = "MultiBinding_Dagger2_Demo"
    init {
        Log.d(TAG, "view Model -> name = $provider")
    }
}

class MainViewModelFactory(val provider: StringProvider): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(provider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}