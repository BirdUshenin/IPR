package com.example.ipr.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.ipr.data.Users

class UsersItemDiffCallback : DiffUtil.ItemCallback<Users>() {

    override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem == newItem
    }
}