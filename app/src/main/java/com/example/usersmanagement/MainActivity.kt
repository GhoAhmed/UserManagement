package com.example.usersmanagement

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val TAG: String = "Check Response"

    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Set up RecyclerView
        recyclerView = findViewById(R.id.recycler_view_users)
        progressBar = findViewById(R.id.progress_bar)
        userAdapter = UserAdapter(listOf(), this)
        recyclerView.adapter = userAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch users from API
        fetchUsers()
    }

    private  fun  fetchUsers() {
        progressBar.visibility = View.VISIBLE

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApiService::class.java)

        api.getUsers().enqueue(object : Callback<List<Users>>{
            override fun onResponse(
                call: Call<List<Users>>,
                response: Response<List<Users>>
            ){
                progressBar.visibility = View.GONE
                if(response.isSuccessful){
                    response.body()?.let{
                        userAdapter.updateUserList(it)
                        Log.i(TAG, "User list updated with ${it.size} users")
                    }
                }
            }
            override fun onFailure(call: retrofit2.Call<List<Users>>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }
        })
    }
}