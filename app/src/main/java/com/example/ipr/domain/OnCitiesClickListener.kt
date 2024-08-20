package com.example.ipr.domain

import com.example.ipr.data.CitiesItem

interface OnCitiesClickListener {
    fun onCitiesItemClicked(cities: CitiesItem)
}