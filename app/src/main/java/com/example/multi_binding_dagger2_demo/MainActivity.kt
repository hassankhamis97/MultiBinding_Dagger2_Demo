package com.example.multi_binding_dagger2_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.multi_binding_dagger2_demo.di.StringProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    private val TAG = "MainActivity"
    @Inject
    lateinit var stringProvider: Set<@JvmSuppressWildcards StringProvider>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: $stringProvider")
    }
}