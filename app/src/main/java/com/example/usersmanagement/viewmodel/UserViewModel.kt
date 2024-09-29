package com.example.usersmanagement.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usersmanagement.data.UserApiService
import com.example.usersmanagement.data.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(private val apiService: UserApiService) : ViewModel() {
    private val _users = MutableLiveData<List<Users>>()
    val users: LiveData<List<Users>> get() = _users

    fun fetchUsers() {
        apiService.getUsers().enqueue(object : Callback<List<Users>> {
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                if (response.isSuccessful) {
                    _users.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                // Handle the error (optional)
            }
        })
    }
}