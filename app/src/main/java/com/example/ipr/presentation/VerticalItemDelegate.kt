package com.example.ipr.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ipr.R
import com.example.ipr.data.VerticalItem

class VerticalItemDelegate : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return VerticalItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Any) {
        if (holder is VerticalItemViewHolder && item is VerticalItem) {
            holder.bind(item)
        }
    }

//    override fun isForViewType(item: Any): Boolean {
//        TODO("Not yet implemented")
//    }

    override fun isForViewType(item: Any): Boolean {
        return item is VerticalItem
    }
}

class VerticalItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: VerticalItem) {

    }
}
