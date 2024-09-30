package com.example.usersmanagement.di

import com.example.usersmanagement.data.UserApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module // Dagger Hilt module responsible for providing network-related dependencies
@InstallIn(SingletonComponent::class) // Indicates that this module is installed in the SingletonComponent
object NetworkModule {

    @Provides // Provides a singleton instance of UserApiService for dependency injection
    @Singleton
    fun provideUserApiService(): UserApiService {
        // Returns an instance of UserApiService with the base URL configured
        return UserApiService.create("https://jsonplaceholder.typicode.com/")
    }
}