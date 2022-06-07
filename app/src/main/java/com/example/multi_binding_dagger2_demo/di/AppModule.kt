package com.example.multi_binding_dagger2_demo.di

import dagger.Module
import dagger.Provides


interface StringProvider {
    fun provide(): String
}

class HelloWorldStringProviderImpl: StringProvider {
    override fun provide(): String {
        return "Hello World"
    }
}

@Module
class AppModule {
    @Provides
    fun provideStringProviderImpl(): StringProvider{
        return HelloWorldStringProviderImpl()
    }

}