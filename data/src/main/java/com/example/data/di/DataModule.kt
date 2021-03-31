package com.example.data.di

import dagger.Module

@Module(includes = [RepositoryModule::class,
    NetworkModule::class,
    DBModule::class])
class DataModule