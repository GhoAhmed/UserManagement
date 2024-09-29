package com.example.usersmanagement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    private var userList: List<Users> = listOf()

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.text_user_name)
        val usernameTextView: TextView = itemView.findViewById(R.id.text_user_username)
        val emailTextView: TextView = itemView.findViewById(R.id.text_user_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.nameTextView.text = user.name
        holder.usernameTextView.text = user.username
        holder.emailTextView.text = user.email
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUserList(users: List<Users>) {
        userList = users
        notifyDataSetChanged()
    }
}