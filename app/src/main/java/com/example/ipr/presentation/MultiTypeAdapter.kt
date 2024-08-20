package com.example.ipr.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ipr.domain.RecyclerItem

class MultiTypeAdapter(
    private val delegates: List<AdapterDelegate>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<RecyclerItem> = emptyList()

    fun submitList(newList: List<RecyclerItem>) {
        val diffCallback = DiffCallback(items, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items = newList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return delegates.indexOfFirst { it.isForViewType(item) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegates[viewType].onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        delegates[holder.itemViewType].onBindViewHolder(holder, item)
    }

    override fun getItemCount(): Int = items.size
}
