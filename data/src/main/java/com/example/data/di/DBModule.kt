package com.example.data.di

import android.content.Context
import com.example.data.source.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DBModule {

    @Singleton
    @Provides
    fun providesDB(context: Context): AppDatabase
    = AppDatabase.invoke(context)

}