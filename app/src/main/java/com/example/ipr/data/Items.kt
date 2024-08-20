package com.example.ipr.data

import com.example.ipr.domain.RecyclerItem

data class VerticalItem(
    val id: Int,
    val photo: Int,
    val name: String,
    val surname: String,
    val phoneNumber: String
) : RecyclerItem {
    override fun item(): Int = id
}

data class HorizontalItem(
    val id: Int,
    val title: String,
    val subItems: List<SubItem>
) : RecyclerItem {
    override fun item(): Int = id
}

data class SubItem(val photo: Int)