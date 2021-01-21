package com.example.multi_binding_dagger2_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.multi_binding_dagger2_demo.di.HelloWorldStringProviderImp
import com.example.multi_binding_dagger2_demo.di.StringProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    private val TAG = "MultiBinding_Dagger2_Demo"
    @Inject
    lateinit var stringProvider: Map<Class<*>, @JvmSuppressWildcards StringProvider>

    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: $stringProvider")
        stringProvider.forEach {
            Log.d(TAG, "onCreate: ${it.value.provide()}")
        }

        val strProv = stringProvider[HelloWorldStringProviderImp::class.java]

        Log.d(TAG, "strProv = $strProv")

//        viewModelFactory = MainViewModelFactory(strProv!!)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


    }
}