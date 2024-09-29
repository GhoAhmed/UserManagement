package com.example.usersmanagement.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.usersmanagement.R
import com.example.usersmanagement.data.UserApiService
import com.example.usersmanagement.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG: String = "Check Response"

    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: View

    // Hilt will inject UserViewModel
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recycler_view_users)
        progressBar = findViewById(R.id.progress_bar)
        userAdapter = UserAdapter(listOf(), this)
        recyclerView.adapter = userAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe users LiveData from ViewModel
        userViewModel.users.observe(this) { users ->
            progressBar.visibility = View.GONE
            users?.let {
                userAdapter.updateUserList(it)
                Log.i(TAG, "User list updated with ${it.size} users")
            }
        }

        // Fetch users from API
        fetchUsers()
    }

    private fun fetchUsers() {
        progressBar.visibility = View.VISIBLE
        userViewModel.fetchUsers()
    }
}