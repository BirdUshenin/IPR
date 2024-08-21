package com.example.ipr.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipr.R
import com.example.ipr.data.CitiesItem
import com.example.ipr.data.SubItem
import com.example.ipr.domain.OnCitiesClickListener
import com.example.ipr.data.RecyclerItem

class CitiesItemDelegate(
    private val clickListener: OnCitiesClickListener?
) : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cities, parent, false)
        return HorizontalItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: RecyclerItem) {
        if (holder is HorizontalItemViewHolder && item is CitiesItem) {
            holder.bind(item) { subItem ->
                clickListener?.onCitiesItemClicked(subItem.name)
            }
        }
    }

    override fun isForViewType(item: RecyclerItem): Boolean {
        return item is CitiesItem
    }
}

class HorizontalItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val horizontalRecyclerView: RecyclerView = itemView.findViewById(R.id.recyclerView)

    fun bind(item: CitiesItem, clickListener: (SubItem) -> Unit) {
        horizontalRecyclerView.layoutManager =
            LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        val horizontalAdapter = InnerCitiesAdapter(item.subItems, clickListener)
        horizontalRecyclerView.adapter = horizontalAdapter
    }
}