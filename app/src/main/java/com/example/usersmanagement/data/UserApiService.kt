package com.example.usersmanagement.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserApiService {
    companion object {
        fun create(baseUrl: String): UserApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(UserApiService::class.java)
        }
    }

    @GET("users")
    fun getUsers(): Call<List<Users>>
}