package com.example.ipr.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ipr.domain.OnUserItemClickListener

class MultiTypeAdapter(
    private val delegates: List<AdapterDelegate>,
    private val clickListener: OnUserItemClickListener?
) : ListAdapter<Any, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return delegates.indexOfFirst { it.isForViewType(item) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegates[viewType].onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        delegates[holder.itemViewType].onBindViewHolder(holder, item)
    }
}
