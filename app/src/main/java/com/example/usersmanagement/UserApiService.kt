package com.example.usersmanagement

import retrofit2.Call
import retrofit2.http.GET

interface UserApiService {
    @GET("users")
    fun getUsers(): Call<List<Users>>
}