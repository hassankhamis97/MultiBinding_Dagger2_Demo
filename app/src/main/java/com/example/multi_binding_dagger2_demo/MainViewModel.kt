package com.example.multi_binding_dagger2_demo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.multi_binding_dagger2_demo.di.StringProvider
import com.example.multi_binding_dagger2_demo.di.WelcomeStringProviderImp
import javax.inject.Inject
import javax.inject.Provider

class MainViewModel @Inject constructor(): ViewModel() {
    private val TAG = "MultiBinding_Dagger2_Demo"
    init {
        Log.d(TAG, "view Model -> Initialize ViewModel")
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

class DaggerViewModelFactory @Inject constructor(private val viewModels: Map<Class<*>, @JvmSuppressWildcards ViewModel>): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return viewModels[MainViewModel::class.java] as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}