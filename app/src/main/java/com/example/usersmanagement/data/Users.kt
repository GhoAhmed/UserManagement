package com.example.usersmanagement.data

// Data class representing a user with detailed information.
data class Users(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val company: Company
)
