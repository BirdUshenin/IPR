package com.example.ipr.domain

import com.example.ipr.data.VerticalItem

interface OnUserItemClickListener {
    fun onUserItemClicked(user: VerticalItem)
}