package com.example.ipr.data

data class SimpsonsItem(
    val id: Int,
    val photo: Int,
    val name: String,
    val surname: String,
    val phoneNumber: String
) : RecyclerItem {
    override fun itemTag(): String = "SimpsonsItem $name"
}

data class CitiesItem(
    val id: Int,
    val title: String,
    val subItems: List<SubItem>
) : RecyclerItem {
    override fun itemTag(): String = "CitiesItem $title"
}

data class SubItem(val photo: Int, val name: String)