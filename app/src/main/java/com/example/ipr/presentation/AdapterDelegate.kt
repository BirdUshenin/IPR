package com.example.ipr.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ipr.domain.RecyclerItem

interface AdapterDelegate {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: RecyclerItem)
    fun isForViewType(item: RecyclerItem): Boolean
}
