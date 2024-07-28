package com.example.ipr.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ipr.R
import com.example.ipr.data.Users
import com.squareup.picasso.Picasso

class UsersItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var PhotoUser: ImageView = view.findViewById(R.id.photo)
    val NameUser = view.findViewById<TextView>(R.id.name)
    val Surname = view.findViewById<TextView>(R.id.surname)
    val Number = view.findViewById<TextView>(R.id.number)

    fun bind(users: Users){
        NameUser.text = users.name
        Surname.text = users.surname
        Number.text = users.phoneNumber
        Picasso.get()
            .load(users.photo)
            .into(PhotoUser)
    }
}