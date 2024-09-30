package com.example.usersmanagement.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Interface for defining API requests related to user data
interface UserApiService {
    // Companion object to handle Retrofit instance creation and API initialization
    companion object {
        fun create(baseUrl: String): UserApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            // Create and return the UserApiService interface implementation
            return retrofit.create(UserApiService::class.java)
        }
    }
    // API call to fetch a list of users from the server
    @GET("users")
    fun getUsers(): Call<List<Users>>
}