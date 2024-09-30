package com.example.usersmanagement.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.usersmanagement.R
import com.example.usersmanagement.data.Users

// Adapter for displaying user data in a RecyclerView
class UserAdapter(private var userList: List<Users>, private val context: Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    // ViewHolder class to hold and recycle views as needed
    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.text_user_name)
        val usernameTextView: TextView = itemView.findViewById(R.id.text_user_username)
        val emailTextView: TextView = itemView.findViewById(R.id.text_user_email)
        val detailsButton: Button = itemView.findViewById(R.id.button_details)
    }

    // Inflates the item layout and creates the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    // Binds data to the ViewHolder for each item in the list
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.nameTextView.text = user.name
        holder.usernameTextView.text = user.username
        holder.emailTextView.text = user.email

        // Set up the click listener for the Details button
        holder.detailsButton.setOnClickListener {
            val intent = Intent(context, UserDetailsActivity::class.java).apply {
                putExtra("name", user.name)
                putExtra("username", user.username)
                putExtra("email", user.email)
                putExtra("address", user.address.city)
                putExtra("phone", user.phone)
                putExtra("company", user.company.name)
            }
            context.startActivity(intent)
        }
    }

    // Returns the total number of items in the user list
    override fun getItemCount(): Int {
        return userList.size
    }

    // Method to update the list of users in the adapter and notify the RecyclerView of the data change
    fun updateUserList(users: List<Users>) {
        userList = users
        notifyDataSetChanged()
    }
}