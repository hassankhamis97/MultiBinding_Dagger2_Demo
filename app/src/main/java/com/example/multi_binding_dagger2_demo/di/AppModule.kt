package com.example.multi_binding_dagger2_demo.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import javax.inject.Inject


interface StringProvider {
    fun provide(): String
}

class HelloWorldStringProviderImpl @Inject constructor(): StringProvider {
    override fun provide(): String {
        return "Hello World"
    }
}

@Module
abstract class AppModule {
//    @Provides
//    fun provideStringProviderImpl(): StringProvider{
//        return HelloWorldStringProviderImpl()
//    }

    @Binds
    abstract fun bindHelloWorld(helloWorldStringProviderImpl: HelloWorldStringProviderImpl): StringProvider
}