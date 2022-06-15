package com.example.hiltsample.di

import com.example.hiltsample.repo.Repository
import com.example.hiltsample.repo.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
abstract class ViewModelModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): Repository
}