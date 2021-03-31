package com.example.weatherapp.di.module

import com.example.weatherapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity

}