package com.example.usersmanagement.data

// Data class representing an Address, typically used to hold user address information.
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)

