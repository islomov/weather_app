package com.example.weatherapp.di.module

import android.content.Context
import android.content.SharedPreferences
import com.example.weatherapp.common.PermissionManager
import dagger.Module
import dagger.Provides

@Module
class ManagerModule {


    @Provides
    fun providesSharedPreference(context: Context): SharedPreferences {
        return context
            .applicationContext
            .getSharedPreferences("APP", Context.MODE_PRIVATE)
    }

    @Provides
    fun providesPermissionManager(preferences: SharedPreferences): PermissionManager {
        return PermissionManager(preferences)
    }

}