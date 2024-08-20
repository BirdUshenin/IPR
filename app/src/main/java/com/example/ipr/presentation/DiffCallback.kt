package com.example.ipr.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.ipr.domain.RecyclerItem

class DiffCallback(
    private val oldList: List<RecyclerItem>,
    private val newList: List<RecyclerItem>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.item() == newItem.item()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
