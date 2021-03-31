package com.example.weatherapp.common

import android.app.Application
import com.example.weatherapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>


    override fun androidInjector(): AndroidInjector<Any> = androidInjector


    override fun onCreate() {
        super.onCreate()
        setupDagger()
    }


    private fun setupDagger() {
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
     }
}