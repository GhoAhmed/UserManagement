package com.example.usersmanagement.di

import com.example.usersmanagement.data.UserApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideUserApiService(): UserApiService {
        return UserApiService.create("https://jsonplaceholder.typicode.com/")
    }
}