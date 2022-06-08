package com.example.multi_binding_dagger2_demo.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Inject


interface StringProvider {
    fun provide(): String
}

class HelloWorldStringProviderImpl @Inject constructor(): StringProvider {
    override fun provide(): String {
        return "Hello World"
    }
}

class WelcomeStringProviderImpl @Inject constructor(): StringProvider {
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
    @ClassKey(HelloWorldStringProviderImpl::class)
    abstract fun bindHelloWorld(helloWorldStringProviderImpl: HelloWorldStringProviderImpl): StringProvider

    @Binds
    @IntoMap
    @ClassKey(WelcomeStringProviderImpl::class)
    abstract fun bindWelcome(welcomeStringProviderImpl: WelcomeStringProviderImpl): StringProvider
}