package com.example.multi_binding_dagger2_demo.di

import com.example.multi_binding_dagger2_demo.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}