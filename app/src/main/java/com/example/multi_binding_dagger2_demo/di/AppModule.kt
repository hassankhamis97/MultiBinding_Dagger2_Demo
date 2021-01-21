package com.example.multi_binding_dagger2_demo.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import javax.inject.Inject


interface StringProvider {
    fun provide(): String
}

class HelloWorldStringProviderImp @Inject constructor(): StringProvider {
    override fun provide(): String {
        return "Hello World"
    }
}

class WelcomeStringProviderImp @Inject constructor(): StringProvider {
    override fun provide(): String {
        return "Welcome"
    }
}

@Module
abstract class AppModule {
//    @Provides
//    fun provideStringProviderImp(): StringProvider{
//        return HelloWorldStringProviderImp()
//    }

//    @Binds
//    @IntoSet
//    abstract fun bindHelloWorld(helloWorldStringProviderImp: HelloWorldStringProviderImp): StringProvider
//
//    @Binds
//    @IntoSet
//    abstract fun bindWelcome(welcomeStringProviderImp: WelcomeStringProviderImp): StringProvider

    companion object {
        @Provides
        fun provideStringProvider(): Set<StringProvider> {
            return setOf(
                    HelloWorldStringProviderImp(),
                    WelcomeStringProviderImp()
            )
        }
    }
}