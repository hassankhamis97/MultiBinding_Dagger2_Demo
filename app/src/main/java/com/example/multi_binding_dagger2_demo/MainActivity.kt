package com.example.multi_binding_dagger2_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.multi_binding_dagger2_demo.di.StringProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    private val TAG = "StringProvider"
    @Inject
    lateinit var stringProvider: Map<String, @JvmSuppressWildcards StringProvider>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: $stringProvider")
        stringProvider.forEach {
            Log.d(TAG, "onCreate: ${it.value.provide()}")
        }

        val strProv = stringProvider["HelloWorld"]

        Log.d(TAG, "strProv = $strProv")


    }
}