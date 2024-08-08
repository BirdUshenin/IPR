package com.example.ipr.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ipr.R
import com.example.ipr.data.Users
import com.example.ipr.domain.OnUserItemClickListener

class AdapterUsers : ListAdapter<Users, UsersItemViewHolder>(UsersItemDiffCallback()) {

    var clickListener: OnUserItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return UsersItemViewHolder(view)
    }

    fun setOnUserItemClickListener(listener: OnUserItemClickListener) {
        clickListener = listener
    }

    override fun onBindViewHolder(viewHolder: UsersItemViewHolder, position: Int) {
        val user = getItem(position)
        viewHolder.bind(user)
        viewHolder.itemView.setOnClickListener {
            clickListener?.onUserItemClicked(user)
        }
    }
}