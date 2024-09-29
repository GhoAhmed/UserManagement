package com.example.usersmanagement.data

data class Users(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val company: Company
)
