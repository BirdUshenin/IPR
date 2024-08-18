package com.example.ipr.data

data class VerticalItem(
    val id: Int,
    val photo: Int,
    val name: String,
    val surname: String,
    val phoneNumber: String
)

data class HorizontalItem(
    val id: Int,
    val title: String,
    val subItems: List<SubItem>
)

data class SubItem(val photo: Int)