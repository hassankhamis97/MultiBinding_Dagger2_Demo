package com.example.multi_binding_dagger2_demo.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet


interface StringProvider {
    fun provide(): String
}

class HelloWorldStringProviderImp: StringProvider {
    override fun provide(): String {
        return "Hello World"
    }
}

@Module
class AppModule {
    @Provides
    fun provideStringProviderImp(): StringProvider{
        return HelloWorldStringProviderImp()
    }

}