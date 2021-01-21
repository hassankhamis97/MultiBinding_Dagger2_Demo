package com.example.multi_binding_dagger2_demo

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel constructor(val name: String): ViewModel() {
    private val TAG = "MultiBinding_Dagger2_Demo"
    init {
        Log.d(TAG, "view Model -> name = $name")
    }
}