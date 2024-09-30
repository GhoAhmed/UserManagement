package com.example.usersmanagement.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usersmanagement.data.UserApiService
import com.example.usersmanagement.data.Users
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

// ViewModel responsible for handling user-related data and managing API calls
@HiltViewModel
class UserViewModel @Inject constructor(private val apiService: UserApiService) : ViewModel() {
    // Backing property for the LiveData holding the list of users
    private val _users = MutableLiveData<List<Users>>()
    // Public LiveData to expose the list of users to the UI
    val users: LiveData<List<Users>> get() = _users
    // LiveData for holding error messages
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchUsers() {
        apiService.getUsers().enqueue(object : Callback<List<Users>> {
            // Called when the API call is successful
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                if (response.isSuccessful) {
                    // Update the LiveData with the retrieved users
                    _users.value = response.body()
                }
            }
            // Called when the API call fails
            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                _error.value = "Failed to load data: ${t.message}"
            }
        })
    }
}
