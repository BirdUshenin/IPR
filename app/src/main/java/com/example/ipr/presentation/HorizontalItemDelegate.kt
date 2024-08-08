package com.example.ipr.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ipr.R
import com.example.ipr.data.HorizontalItem

class HorizontalItemDelegate : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return HorizontalItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Any) {
        if (holder is HorizontalItemViewHolder && item is HorizontalItem) {
            holder.bind(item)
        }
    }

    override fun isForViewType(item: Any): Boolean {
        return item is HorizontalItem
    }
}

class HorizontalItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: HorizontalItem) {

    }
}
