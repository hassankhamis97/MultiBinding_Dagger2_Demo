package com.example.multi_binding_dagger2_demo.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey
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



//    companion object {
//        @Provides
//        fun provideStringProvider(): Set<StringProvider> {
//            return setOf(
//                    HelloWorldStringProviderImp(),
//                    WelcomeStringProviderImp()
//            )
//        }
//    }

    @Binds
    @IntoMap
    @StringKey("HelloWorld")
    abstract fun bindHelloWorld(helloWorldStringProviderImp: HelloWorldStringProviderImp): StringProvider

    @Binds
    @IntoMap
    @StringKey("Welcome")
    abstract fun bindWelcome(welcomeStringProviderImp: WelcomeStringProviderImp): StringProvider
}