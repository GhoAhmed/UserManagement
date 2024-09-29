package com.example.usersmanagement.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.usersmanagement.data.UserApiService

class UserViewModelFactory(private val apiService: UserApiService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}