package com.example.multi_binding_dagger2_demo.di

import androidx.lifecycle.ViewModelProvider
import com.example.multi_binding_dagger2_demo.DaggerViewModelFactory
import com.example.multi_binding_dagger2_demo.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
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
    @ClassKey(HelloWorldStringProviderImp::class)
    abstract fun bindHelloWorld(helloWorldStringProviderImp: HelloWorldStringProviderImp): StringProvider

    @Binds
    @IntoMap
    @ClassKey(WelcomeStringProviderImp::class)
    abstract fun bindWelcome(welcomeStringProviderImp: WelcomeStringProviderImp): StringProvider

    @Binds
    abstract fun bindViewModelFactory(daggerViewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}