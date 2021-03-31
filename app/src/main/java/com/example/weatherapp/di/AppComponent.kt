package com.example.weatherapp.di

import com.example.data.di.DataModule
import com.example.weatherapp.common.App
import com.example.weatherapp.di.module.ActivityBuilderModule
import com.example.weatherapp.di.module.AppModule
import com.example.weatherapp.di.module.ManagerModule
import com.example.weatherapp.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityBuilderModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        DataModule::class,
        ManagerModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(app: App): Builder
    }

    override fun inject(app: App)

}
