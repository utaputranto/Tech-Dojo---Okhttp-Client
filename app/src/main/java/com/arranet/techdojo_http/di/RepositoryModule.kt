package com.arranet.techdojo_http.di

import com.arranet.techdojo_http.data.repository.AppRepository
import com.arranet.techdojo_http.data.repository.AppRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideAppRepository(appRepositoryImpl: AppRepositoryImpl): AppRepository

}