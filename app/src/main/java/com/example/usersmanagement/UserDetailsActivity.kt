package com.example.usersmanagement

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserDetailsActivity : AppCompatActivity() {
    private lateinit var textDetailName: TextView
    private lateinit var textDetailUsername: TextView
    private lateinit var textDetailEmail: TextView
    private lateinit var textDetailAddress: TextView
    private lateinit var textDetailPhone: TextView
    private lateinit var textDetailCompany: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        textDetailName = findViewById(R.id.text_detail_name)
        textDetailUsername = findViewById(R.id.text_detail_username)
        textDetailEmail = findViewById(R.id.text_detail_email)
        textDetailAddress = findViewById(R.id.text_detail_address)
        textDetailPhone = findViewById(R.id.text_detail_phone)
        textDetailCompany = findViewById(R.id.text_detail_company)

        // Get the data from the Intent
        val name = intent.getStringExtra("name")
        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val address = intent.getStringExtra("address")
        val phone = intent.getStringExtra("phone")
        val company = intent.getStringExtra("company")

        // Set the data to TextViews
        textDetailName.text = name
        textDetailUsername.text = username
        textDetailEmail.text = email
        textDetailAddress.text = address
        textDetailPhone.text = phone
        textDetailCompany.text = company
    }
}