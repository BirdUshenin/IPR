package com.example.ipr.domain

import com.example.ipr.data.VerticalItem

interface OnUserEditListener {
    fun onUserEdited(user: VerticalItem)
}