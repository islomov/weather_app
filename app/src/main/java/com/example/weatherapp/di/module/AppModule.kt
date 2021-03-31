package com.example.weatherapp.di.module

import android.content.Context
import com.example.weatherapp.common.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesAppContext(app: App): Context {
        return app
    }

}