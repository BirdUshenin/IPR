package com.example.ipr.domain

import com.example.ipr.data.RecyclerItem

interface OnUserEditListener {
    fun onUserEdited(user: RecyclerItem)
}