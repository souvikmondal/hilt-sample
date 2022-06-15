package com.example.hiltsample.di

import com.example.hiltsample.logger.Logger
import com.example.hiltsample.logger.LoggerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideLogger(): Logger {
        return LoggerImpl("com.example.hiltsample")
    }
}