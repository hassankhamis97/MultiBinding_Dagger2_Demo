package com.example.multi_binding_dagger2_demo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.multi_binding_dagger2_demo.di.StringProvider
import com.example.multi_binding_dagger2_demo.di.WelcomeStringProviderImp
import javax.inject.Inject

class MainViewModel constructor(val provider: StringProvider): ViewModel() {
    private val TAG = "MultiBinding_Dagger2_Demo"
    init {
        Log.d(TAG, "view Model -> name = $provider")
    }
}

//class MainViewModelFactory @Inject constructor(val provider: Map<Class<*>, @JvmSuppressWildcards StringProvider>): ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        @Suppress("UNCHECKED_CAST")
//        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
//            return MainViewModel(provider[WelcomeStringProviderImp::class.java]!!) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}

class DaggerViewModelFactory @Inject constructor(val provider: Map<Class<*>, @JvmSuppressWildcards StringProvider>): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(provider[WelcomeStringProviderImp::class.java]!!) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}